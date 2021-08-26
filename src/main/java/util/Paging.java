package util;

public class Paging {
	public static String getPaging(String pageURL, int nowPage, int rowTotal, int blockList, int blockPage) {

		int totalPage, startPage, endPage;

		boolean isPrevPage, isNextPage;
		StringBuffer sb; 

		isPrevPage = isNextPage = false;

		totalPage = rowTotal / blockList;
		if (rowTotal % blockList != 0)
			totalPage++;


		if (nowPage > totalPage)
			nowPage = totalPage;

	
		startPage = (int) (((nowPage - 1) / blockPage) * blockPage + 1);
		endPage = startPage + blockPage - 1; //

		
		if (endPage > totalPage)
			endPage = totalPage;

		if (endPage < totalPage)
			isNextPage = true;
		
		if (startPage > 1)
			isPrevPage = true;

		
		sb = new StringBuffer();
//-----이전 페이지버튼부분 --------------------------------------------------------------------------------------------		
		if (isPrevPage) {
			sb.append("<a href ='" + pageURL + "?page=");
			sb.append(startPage - 1);
			sb.append("'>◀</a>");
		} else
			sb.append("◀");

		//-----중단 페이징되는 숫자들 --------------------------------------------------------------------------------------------
		sb.append("|");
		for (int i = startPage; i <= endPage; i++) {

			if (i > totalPage)
				break;

			if (i == nowPage) { 
				sb.append("&nbsp;<b><font color='red'>");
				sb.append(i);
				sb.append("</font></b>");
			} else {
				sb.append("&nbsp;<a href='" + pageURL + "?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		} // end for

		sb.append("&nbsp;|");

		//-----다음 페이지버튼부분 --------------------------------------------------------------------------------------------
		if (isNextPage) {
			sb.append("<a href='" + pageURL + "?page=");
			sb.append(endPage + 1);
			sb.append("'>▶</a>");
		} else
			sb.append("▶");
//---------------------------------------------------------------------------------------------------------------------	    

		return sb.toString();

	}// end-getPaging()

	public static String getPaging(String pageURL, int nowPage, int rowTotal, String searchFilter, int blockList,
			int blockPage) {

		int totalPage, startPage, endPage;

		boolean isPrevPage, isNextPage;
		StringBuffer sb; 

		isPrevPage = isNextPage = false;

		
		totalPage = rowTotal / blockList;
		if (rowTotal % blockList != 0)
			totalPage++;

		if (nowPage > totalPage)
			nowPage = totalPage;

		
		startPage = (int) (((nowPage - 1) / blockPage) * blockPage + 1);
		endPage = startPage + blockPage - 1; //

		if (endPage > totalPage)
			endPage = totalPage;

		if (endPage < totalPage)
			isNextPage = true;

		if (startPage > 1)
			isPrevPage = true;

		sb = new StringBuffer();
		// --------------------------------------------------------------------------------------------
		if (isPrevPage) {
			sb.append("<a href ='" + pageURL + "?page=");
			sb.append(startPage - 1);

			sb.append(searchFilter);

			sb.append("'>◀</a>");
		} else
			sb.append("◀");
		
		// -------------------------------------------------------------------------------------------------
		sb.append("|");
		for (int i = startPage; i <= endPage; i++) {

			if (i > totalPage)
				break;

			if (i == nowPage) { // 현재 페이지 숫자인 경우
				sb.append("&nbsp;<b><font color='red'>");
				sb.append(i);
				sb.append("</font></b>");
			} else {// 현재 페이지 숫자가 아닌 경우
				sb.append("&nbsp;<a href='" + pageURL + "?page=");
				sb.append(i);

				sb.append(searchFilter);

				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		} // end for

		sb.append("&nbsp;|");

		// ----------------------------------------------------------------------------------------------
		if (isNextPage) {
			sb.append("<a href='" + pageURL + "?page=");
			sb.append(endPage + 1);

			sb.append(searchFilter);

			sb.append("'>▶</a>");
		} else
			sb.append("▶");
		// ---------------------------------------------------------------------------------------------------------------------

		return sb.toString();
	}


	public static String getReviewPaging(String pageURL, int nowPage, int rowTotal, int blockList,
			int blockPage) {

		int totalPage, startPage, endPage;

		boolean isPrevPage, isNextPage;
		StringBuffer sb; 

		isPrevPage = isNextPage = false;

		
		totalPage = rowTotal / blockList;
		if (rowTotal % blockList != 0)
			totalPage++;
		if (nowPage > totalPage)
			nowPage = totalPage;

		
		startPage = (int) (((nowPage - 1) / blockPage) * blockPage + 1);
		endPage = startPage + blockPage - 1; //

		
		if (endPage > totalPage)
			endPage = totalPage;

		if (endPage < totalPage)
			isNextPage = true;
		if (startPage > 1)
			isPrevPage = true;

		
		sb = new StringBuffer();
		// --------------------------------------------------------------------------------------------
		if (isPrevPage) {
			sb.append("<a href ='" + pageURL + "&page=");
			sb.append(startPage - 1);

			sb.append("'>◀</a>");
		} else
			sb.append("◀");

		// -------------------------------------------------------------------------------------------------
		sb.append("|");
		for (int i = startPage; i <= endPage; i++) {

			if (i > totalPage)
				break;

			if (i == nowPage) { //현재 페이지의 숫자인 경우
				sb.append("&nbsp;<b><font color='red'>");
				sb.append(i);
				sb.append("</font></b>");
			} else {// 현재 페이지 숫자가 아닌 경우
				sb.append("&nbsp;<a href='" + pageURL + "&page=");
				sb.append(i);

				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		} // end for

		sb.append("&nbsp;|");

		// ----------------------------------------------------------------------------------------------
		if (isNextPage) {
			sb.append("<a href='" + pageURL + "&page=");
			sb.append(endPage + 1);

			sb.append("'>▶</a>");
		} else
			sb.append("▶");
		// ---------------------------------------------------------------------------------------------------------------------

		return sb.toString();
	}
	
	public static String getReviewPaging(int nowPage, int rowTotal, int blockList, int blockPage) {

		int totalPage/* ��ü�������� */, startPage/* ������������ȣ */, endPage;/* ��������������ȣ */

		boolean isPrevPage, isNextPage;
		StringBuffer sb; // ��� ��Ȳ�� �Ǵ��Ͽ� HTML�ڵ带 ������ ��

		isPrevPage = isNextPage = false;

		totalPage = rowTotal / blockList;
		if (rowTotal % blockList != 0)
			totalPage++;

		if (nowPage > totalPage)
			nowPage = totalPage;

		startPage = (int) (((nowPage - 1) / blockPage) * blockPage + 1);
		endPage = startPage + blockPage - 1; //

		if (endPage > totalPage)
			endPage = totalPage;

		if (endPage < totalPage)
			isNextPage = true;

		if (startPage > 1)
			isPrevPage = true;

		sb = new StringBuffer();
//------------------------------------------------------------------------------------------      
		if (isPrevPage) {
			/* <a href="#" onclick="comment_list('1');">1</a> */
			sb.append(String.format("&nbsp;<a href='#' onclick=\"review_list('%d');\">", startPage - 1));
			//sb.append("<a href ='#' onclick=\"comment_list('"+ (startPage-1) +"');\"> ");
			sb.append("◀</a>");
		} else
			sb.append("◀");

//------------------------------------------------------------------------------------------------------
		sb.append("|");
		for (int i = startPage; i <= endPage; i++) {

			if (i > totalPage)
				break;

			if (i == nowPage) { 
				sb.append("&nbsp;<b><font color='red'><span class='page_num'>");
				sb.append(i);
				sb.append("</span></font></b>");
			} else {
				sb.append(String.format("&nbsp;<a href='#' onclick=\"review_list('%d');\"><span class='page_num'>", i));
				sb.append(i);
				sb.append("</span></a>");
			}
		} // end for

		sb.append("&nbsp;|");

//--------------------------------------------------------------------------------------------------
		if (isNextPage) {
			sb.append(String.format("&nbsp;<a href='#' onclick=\"review_list('%d');\">", endPage + 1));
			sb.append("▶</a>");
		} else
			sb.append("▶");
//---------------------------------------------------------------------------------------------------------------------       

		return sb.toString();

	}// end-getReviewPaging()

}