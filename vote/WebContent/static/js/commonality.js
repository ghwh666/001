function pagehtml(data){
	html=`
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>选手1id</th>
						<th>选手1姓名</th>
						<th>选手1歌曲</th>
						<th>选手1图片</th>
						
						<th>选手2id</th>
						<th>选手2姓名</th>
						<th>选手2歌曲</th>
						<th colspan="1" class="col-md-3">操作</th>
					</tr>
					for(var data in datas)${page.getobj}
						<tr>
							<th>${tl.getPlayerId()}</th>
							<th>${tl.getPlayerName() }</th>
							<th><img src="${APP_PATH }/static/img/${tl.getPlayerImg() }" alt="头像" draggable="false" height="50" width="50"></th>
							<th><a href="${APP_PATH }/chakan?Id=${tl.getId()}" class="btn btn-success">查看</a></th>
               				<th><c:choose>
							   <c:when test="${tl.getPlayerId()}">
               					 
							   </c:when>
							   <c:otherwise> 
               					
							   </c:otherwise>
							</c:choose>
               				</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6">当前 ${page.pageNum }页,总${page.pages }
				页,总 ${page.total } 条记录</div>
			<!-- 分页条信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${APP_PATH }/admin/admin?pn=1">首页</a></li>
					<c:if test="${page.hasPreviousPage }">
						<li><a href="${APP_PATH }/admin/admin?pn=${page.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach items="${page.navigatepageNums }" var="page_Num">
						<c:if test="${page_Num == page.pageNum }">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num != page.pageNum }">
							<li><a href="${APP_PATH }/admin/admin?pn=${page_Num }">${page_Num }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${page.hasNextPage }">
						<li><a href="${APP_PATH }/admin/admin?pn=${page.pageNum+1 }"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="${APP_PATH }/admin/admin?pn=${page.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>`;
	
}