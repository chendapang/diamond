package com.fisher.distributedLock.zk.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class DistributedReentrantReadWriteLock implements ReadWriteLock, Watcher{
	private  static String lockName;
	private static DistributedReentrantReadWriteLock.WriteLock writerLock;
	private static ZooKeeper zk;
	private static final int sessionTimeout = 30000;
	private static String root = "/locks";
	private static CountDownLatch latch;
	
	
	  /**
     * Creates a new {@code ReentrantReadWriteLock} with
     * the given fairness policy.
     *
     * @param fair {@code true} if this lock should use a fair ordering policy
	 * @throws Exception 
     */
    public DistributedReentrantReadWriteLock(boolean fair,String config,String lockName) throws Exception {
//        sync = fair ? new FairSync() : new NonfairSync();
//        readerLock = new ReadLock(this);
    	this.lockName = lockName;
        writerLock = new WriteLock(this);
        zk= new ZooKeeper(config, sessionTimeout, this);
        
        Stat stat = zk.exists(root, false);

		if (stat == null) {

			zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

		}
    }
	
	   /**
     * The lock returned by method {@link ReentrantReadWriteLock#writeLock}.
     */
    public static class WriteLock implements Lock  {
//        private final Sync sync;
        private final String lockName;
        private String waitNode;

    	private  String myZnode;

//    	private int sessionTimeout = 30000;
    	
//    	private ZooKeeper zk;

//    	private String root = "/locks";
//    	private CountDownLatch latch;

        /**
         * Constructor for use by subclasses
         *
         * @param lock the outer lock object
         * @throws NullPointerException if the lock is null
         */
        protected WriteLock(DistributedReentrantReadWriteLock lock) {
//            sync = lock.sync;
            lockName = lock.lockName;
          
        }

        /**
         * Acquires the write lock.
         *
         * <p>Acquires the write lock if neither the read nor write lock
         * are held by another thread
         * and returns immediately, setting the write lock hold count to
         * one.
         *
         * <p>If the current thread already holds the write lock then the
         * hold count is incremented by one and the method returns
         * immediately.
         *
         * <p>If the lock is held by another thread then the current
         * thread becomes disabled for thread scheduling purposes and
         * lies dormant until the write lock has been acquired, at which
         * time the write lock hold count is set to one.
         */
        public void lock() {
//            sync.acquire(1);
        	try {

    			if (this.tryLock()) {

    				System.out.println("Thread " + Thread.currentThread().getId() + " " + myZnode + " get lock true");

    				return;

    			} else {

    				waitForLock(waitNode, sessionTimeout);

    			}

    		} catch (KeeperException e) {

    			e.printStackTrace();

//    			throw new LockException(e);

    		} catch (InterruptedException e) {

    			e.printStackTrace();

//    			throw new LockException(e);

    		}
        }
 

        /**
         * Acquires the write lock unless the current thread is
         * {@linkplain Thread#interrupt interrupted}.
         *
         * <p>Acquires the write lock if neither the read nor write lock
         * are held by another thread
         * and returns immediately, setting the write lock hold count to
         * one.
         *
         * <p>If the current thread already holds this lock then the
         * hold count is incremented by one and the method returns
         * immediately.
         *
         * <p>If the lock is held by another thread then the current
         * thread becomes disabled for thread scheduling purposes and
         * lies dormant until one of two things happens:
         *
         * <ul>
         *
         * <li>The write lock is acquired by the current thread; or
         *
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread.
         *
         * </ul>
         *
         * <p>If the write lock is acquired by the current thread then the
         * lock hold count is set to one.
         *
         * <p>If the current thread:
         *
         * <ul>
         *
         * <li>has its interrupted status set on entry to this method;
         * or
         *
         * <li>is {@linkplain Thread#interrupt interrupted} while
         * acquiring the write lock,
         *
         * </ul>
         *
         * then {@link InterruptedException} is thrown and the current
         * thread's interrupted status is cleared.
         *
         * <p>In this implementation, as this method is an explicit
         * interruption point, preference is given to responding to
         * the interrupt over normal or reentrant acquisition of the
         * lock.
         *
         * @throws InterruptedException if the current thread is interrupted
         */
        public void lockInterruptibly() throws InterruptedException {
//            sync.acquireInterruptibly(1);
        }

        /**
         * Acquires the write lock only if it is not held by another thread
         * at the time of invocation.
         *
         * <p>Acquires the write lock if neither the read nor write lock
         * are held by another thread
         * and returns immediately with the value {@code true},
         * setting the write lock hold count to one. Even when this lock has
         * been set to use a fair ordering policy, a call to
         * {@code tryLock()} <em>will</em> immediately acquire the
         * lock if it is available, whether or not other threads are
         * currently waiting for the write lock.  This &quot;barging&quot;
         * behavior can be useful in certain circumstances, even
         * though it breaks fairness. If you want to honor the
         * fairness setting for this lock, then use {@link
         * #tryLock(long, TimeUnit) tryLock(0, TimeUnit.SECONDS) }
         * which is almost equivalent (it also detects interruption).
         *
         * <p>If the current thread already holds this lock then the
         * hold count is incremented by one and the method returns
         * {@code true}.
         *
         * <p>If the lock is held by another thread then this method
         * will return immediately with the value {@code false}.
         *
         * @return {@code true} if the lock was free and was acquired
         * by the current thread, or the write lock was already held
         * by the current thread; and {@code false} otherwise.
         */
        public boolean tryLock( ) {
//            return sync.tryWriteLock();
        	try {

    			String splitStr = "_lock_";

    			if (lockName.contains(splitStr)){

//    				throw new LockException("lockName can not contains \\u000B");
    				throw new Exception("lockName can not contains \\u000B");
    			}
    			myZnode = zk.create(root + "/" + lockName + splitStr, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
    					CreateMode.EPHEMERAL_SEQUENTIAL);

    			System.out.println(myZnode + " is created ");

    			List<String> subNodes = zk.getChildren(root, false);

    			List<String> lockObjNodes = new ArrayList<String>();

    			for (String node : subNodes) {

    				String _node = node.split(splitStr)[0];

    				if (_node.equals(lockName)) {

    					lockObjNodes.add(node);

    				}

    			}

    			Collections.sort(lockObjNodes);

    			System.out.println(myZnode + "==" + lockObjNodes.get(0));

    			if (myZnode.equals(root + "/" + lockObjNodes.get(0))) {

    				return true;

    			}

    			String subMyZnode = myZnode.substring(myZnode.lastIndexOf("/") + 1);

    			waitNode = lockObjNodes.get(Collections.binarySearch(lockObjNodes, subMyZnode) - 1);

    		} catch (KeeperException e) {

    			e.printStackTrace();

//    			throw new LockException(e);

    		} catch (InterruptedException e) {

    			e.printStackTrace();

//    			throw new LockException(e);

    		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		return false;
        }

        /**
         * Acquires the write lock if it is not held by another thread
         * within the given waiting time and the current thread has
         * not been {@linkplain Thread#interrupt interrupted}.
         *
         * <p>Acquires the write lock if neither the read nor write lock
         * are held by another thread
         * and returns immediately with the value {@code true},
         * setting the write lock hold count to one. If this lock has been
         * set to use a fair ordering policy then an available lock
         * <em>will not</em> be acquired if any other threads are
         * waiting for the write lock. This is in contrast to the {@link
         * #tryLock()} method. If you want a timed {@code tryLock}
         * that does permit barging on a fair lock then combine the
         * timed and un-timed forms together:
         *
         *  <pre> {@code
         * if (lock.tryLock() ||
         *     lock.tryLock(timeout, unit)) {
         *   ...
         * }}</pre>
         *
         * <p>If the current thread already holds this lock then the
         * hold count is incremented by one and the method returns
         * {@code true}.
         *
         * <p>If the lock is held by another thread then the current
         * thread becomes disabled for thread scheduling purposes and
         * lies dormant until one of three things happens:
         *
         * <ul>
         *
         * <li>The write lock is acquired by the current thread; or
         *
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread; or
         *
         * <li>The specified waiting time elapses
         *
         * </ul>
         *
         * <p>If the write lock is acquired then the value {@code true} is
         * returned and the write lock hold count is set to one.
         *
         * <p>If the current thread:
         *
         * <ul>
         *
         * <li>has its interrupted status set on entry to this method;
         * or
         *
         * <li>is {@linkplain Thread#interrupt interrupted} while
         * acquiring the write lock,
         *
         * </ul>
         *
         * then {@link InterruptedException} is thrown and the current
         * thread's interrupted status is cleared.
         *
         * <p>If the specified waiting time elapses then the value
         * {@code false} is returned.  If the time is less than or
         * equal to zero, the method will not wait at all.
         *
         * <p>In this implementation, as this method is an explicit
         * interruption point, preference is given to responding to
         * the interrupt over normal or reentrant acquisition of the
         * lock, and over reporting the elapse of the waiting time.
         *
         * @param timeout the time to wait for the write lock
         * @param unit the time unit of the timeout argument
         *
         * @return {@code true} if the lock was free and was acquired
         * by the current thread, or the write lock was already held by the
         * current thread; and {@code false} if the waiting time
         * elapsed before the lock could be acquired.
         *
         * @throws InterruptedException if the current thread is interrupted
         * @throws NullPointerException if the time unit is null
         */
        public boolean tryLock(long timeout, TimeUnit unit)
                throws InterruptedException {
//            return sync.tryAcquireNanos(1, unit.toNanos(timeout));
        	try {

    			String splitStr = "_lock_";

    			if (lockName.contains(splitStr))

    			{
//    				throw new LockException("lockName can not contains \\u000B");
    			}

    			myZnode = zk.create(root + "/" + lockName + splitStr, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
    					CreateMode.EPHEMERAL_SEQUENTIAL);

    			System.out.println(myZnode + " is created ");

    			List<String> subNodes = zk.getChildren(root, false);

    			List<String> lockObjNodes = new ArrayList<String>();

    			for (String node : subNodes) {

    				String _node = node.split(splitStr)[0];

    				if (_node.equals(lockName)) {

    					lockObjNodes.add(node);

    				}

    			}

    			Collections.sort(lockObjNodes);

    			System.out.println(myZnode + "==" + lockObjNodes.get(0));

    			if (myZnode.equals(root + "/" + lockObjNodes.get(0))) {

    				return true;

    			}

    			String subMyZnode = myZnode.substring(myZnode.lastIndexOf("/") + 1);

    			waitNode = lockObjNodes.get(Collections.binarySearch(lockObjNodes, subMyZnode) - 1);

    		} catch (KeeperException e) {

    			e.printStackTrace();

//    			throw new LockException(e);

    		} catch (InterruptedException e) {

    			e.printStackTrace();

//    			throw new LockException(e);

    		}

    		return false;
        }

        /**
         * Attempts to release this lock.
         *
         * <p>If the current thread is the holder of this lock then
         * the hold count is decremented. If the hold count is now
         * zero then the lock is released.  If the current thread is
         * not the holder of this lock then {@link
         * IllegalMonitorStateException} is thrown.
         *
         * @throws IllegalMonitorStateException if the current thread does not
         * hold this lock
         */
        public void unlock() {
//            sync.release(1);
        	try {

    			System.out.println("unlock " + myZnode);

    			zk.delete(myZnode, -1);

    			myZnode = null;

    			zk.close();

    		} catch (InterruptedException e) {

    			e.printStackTrace();

    		} catch (KeeperException e) {

    			e.printStackTrace();

    		}
        }

        /**
         * Returns a {@link Condition} instance for use with this
         * {@link Lock} instance.
         * <p>The returned {@link Condition} instance supports the same
         * usages as do the {@link Object} monitor methods ({@link
         * Object#wait() wait}, {@link Object#notify notify}, and {@link
         * Object#notifyAll notifyAll}) when used with the built-in
         * monitor lock.
         *
         * <ul>
         *
         * <li>If this write lock is not held when any {@link
         * Condition} method is called then an {@link
         * IllegalMonitorStateException} is thrown.  (Read locks are
         * held independently of write locks, so are not checked or
         * affected. However it is essentially always an error to
         * invoke a condition waiting method when the current thread
         * has also acquired read locks, since other threads that
         * could unblock it will not be able to acquire the write
         * lock.)
         *
         * <li>When the condition {@linkplain Condition#await() waiting}
         * methods are called the write lock is released and, before
         * they return, the write lock is reacquired and the lock hold
         * count restored to what it was when the method was called.
         *
         * <li>If a thread is {@linkplain Thread#interrupt interrupted} while
         * waiting then the wait will terminate, an {@link
         * InterruptedException} will be thrown, and the thread's
         * interrupted status will be cleared.
         *
         * <li> Waiting threads are signalled in FIFO order.
         *
         * <li>The ordering of lock reacquisition for threads returning
         * from waiting methods is the same as for threads initially
         * acquiring the lock, which is in the default case not specified,
         * but for <em>fair</em> locks favors those threads that have been
         * waiting the longest.
         *
         * </ul>
         *
         * @return the Condition object
         */
        public Condition newCondition() {
			return null;
//            return sync.newCondition();
        }

        /**
         * Returns a string identifying this lock, as well as its lock
         * state.  The state, in brackets includes either the String
         * {@code "Unlocked"} or the String {@code "Locked by"}
         * followed by the {@linkplain Thread#getName name} of the owning thread.
         *
         * @return a string identifying this lock, as well as its lock state
         */
        public String toString() {
			return lockName;
//            Thread o = sync.getOwner();
//            return super.toString() + ((o == null) ?
//                                       "[Unlocked]" :
//                                       "[Locked by thread " + o.getName() + "]");
        }

        /**
         * Queries if this write lock is held by the current thread.
         * Identical in effect to {@link
         * ReentrantReadWriteLock#isWriteLockedByCurrentThread}.
         *
         * @return {@code true} if the current thread holds this lock and
         *         {@code false} otherwise
         * @since 1.6
         */
        public boolean isHeldByCurrentThread() {
			return false;
//            return sync.isHeldExclusively();
        }

        /**
         * Queries the number of holds on this write lock by the current
         * thread.  A thread has a hold on a lock for each lock action
         * that is not matched by an unlock action.  Identical in effect
         * to {@link ReentrantReadWriteLock#getWriteHoldCount}.
         *
         * @return the number of holds on this lock by the current thread,
         *         or zero if this lock is not held by the current thread
         * @since 1.6
         */
        public int getHoldCount() {
			return sessionTimeout;
//            return sync.getWriteHoldCount();
        }

	
    }

	@Override
	public DistributedReentrantReadWriteLock.WriteLock writeLock() { return writerLock; }

	@Override
	public Lock readLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(WatchedEvent event) {
		if (this.latch != null) {

			this.latch.countDown();

		}
		
	}
    private static boolean waitForLock(String lower, long waitTime)

 			throws InterruptedException, KeeperException {

 		Stat stat = zk.exists(root + "/" + lower, true);

 		if (stat != null) {

 			System.out.println("Thread " + Thread.currentThread().getId() + " waiting for " + root + "/" + lower);

 			latch = new CountDownLatch(1);

 			latch.await(waitTime, TimeUnit.MILLISECONDS);

 			latch = null;

 		}

 		return true;

 	}
	

}
