package com.ujia.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 用于分页的工具类
 * 
 */
@SuppressWarnings("all")
public class PageInfo<T> implements Serializable {
	private static final long serialVersionUID = -4179101621659598254L;

	private List<T> items; // 对象记录结果集

	private T previousObj;// list中的上一条数据
	private T nextObj;// list中的下一条数据
	private int total = 0; // 总记录数
	private int pageSize = 10; // 每页显示记录数
	private int defaultPageSize = 10; // 每页显示记录数
	private int pages = 1; // 总页数
	private int pageNumber = 1; // 当前页

	private boolean isFirstPage = false; // 是否为第一页
	private boolean isLastPage = false; // 是否为最后一页
	private boolean hasPreviousPage = false; // 是否有前一页
	private boolean hasNextPage = false; // 是否有下一页

	private int navigatePages = 8; // 导航页码数
	private int[] navigatePageNumbers; // 所有导航页号

	public PageInfo(Integer total, Integer pageNumber, Integer pageSize) {
		if (total == null) {
			total = 0;
		}
		if (pageSize == null || pageSize < 5 || pageSize > 30) {
			pageSize = defaultPageSize;
		}
		if (pageNumber == null) {
			pageNumber = 0;
		}
		// pageSize=5;
		init(total, pageNumber, pageSize);
	}

	private void init(int total, int pageNumber, int pageSize) {
		// 设置基本参数
		this.total = total;
		this.pageSize = pageSize;
		if (pageSize == 0) {
			this.pages = 1;
		} else {
			this.pages = (this.total + this.pageSize - 1) / this.pageSize;
		}

		// 根据输入可能错误的当前号码进行自动纠正
		if (pageNumber < 1 || this.pages == 0) {
			this.pageNumber = 1;
		} else if (pageNumber > this.pages) {
			this.pageNumber = this.pages;
		} else {
			this.pageNumber = pageNumber;
		}

		// 基本参数设定之后进行导航页面的计算
		calcNavigatePageNumbers();

		// 以及页面边界的判定
		judgePageBoudary();

	}

	/**
	 * 计算导航页
	 */
	private void calcNavigatePageNumbers() {
		// 当总页数小于或等于导航页码数时
		if (pages <= navigatePages) {
			navigatePageNumbers = new int[pages];
			for (int i = 0; i < pages; i++) {
				navigatePageNumbers[i] = i + 1;
			}
		} else { // 当总页数大于导航页码数时
			navigatePageNumbers = new int[navigatePages];
			int startNum = pageNumber - navigatePages / 2;
			int endNum = pageNumber + navigatePages / 2;

			if (startNum < 1) {
				startNum = 1;
				// (最前navPageCount页
				for (int i = 0; i < navigatePages; i++) {
					navigatePageNumbers[i] = startNum++;
				}
			} else if (endNum > pages) {
				endNum = pages;
				// 最后navPageCount页
				for (int i = navigatePages - 1; i >= 0; i--) {
					navigatePageNumbers[i] = endNum--;
				}
			} else {
				// 所有中间页
				for (int i = 0; i < navigatePages; i++) {
					navigatePageNumbers[i] = startNum++;
				}
			}
		}
	}

	/**
	 * 判定页面边界
	 */
	private void judgePageBoudary() {
		isFirstPage = pageNumber == 1;
		isLastPage = pageNumber == pages && pageNumber != 1;
		hasPreviousPage = pageNumber != 1;
		hasNextPage = pageNumber != pages;
	}

	public void setItems(List<T> list) {

		this.items = list;
		if (list == null || list.size() == 0) {
			return;
		}
	}

	/**
	 * 得到当前页的内容
	 * 
	 * @return {List}
	 */
	public List<T> getItems() {
		return items;
	}

	/**
	 * 得到记录总数
	 * 
	 * @return {int}
	 */
	public int getTotal() {
		return total;
	}
	
	/**
	 * 得到每页显示多少条记录
	 * 
	 * @return {int}
	 */
	public Integer getPageSize() {
		return pageSize;

	}

	/**
	 * 得到页面总数
	 * 
	 * @return {int}
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * 得到当前页号
	 * 
	 * @return {int}
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * 得到所有导航页号
	 * 
	 * @return {int[]}
	 */
//	public int[] getNavigatePageNumbers() {
//		return navigatePageNumbers;
//	}
//
//	public boolean isFirstPage() {
//		return isFirstPage;
//	}
//
//	public boolean isLastPage() {
//		return isLastPage;
//	}
//
//	public boolean isHasPreviousPage() {
//		return hasPreviousPage;
//	}
//
//	public boolean isHasNextPage() {
//		return hasNextPage;
//	}

	public Integer getStartIndex() {
		int startIndex = (pageNumber - 1) * pageSize;

		return startIndex;

	}
	
	
	
	/**
	 * layui需要
	 * @return
	 */
	public int getCount() {
		return total;
	}
	public int getCode() {
		return 0;
	}

}
