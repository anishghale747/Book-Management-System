<%@ include file="fragment/header.jsp" %>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Issued Books</h3>
			<hr>
			
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Book Name</th>
						<th>Student Name</th>
						<th>Student Phone No</th>
						<th>Issue Date</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="issuebook" items="${listIssue}">

						<tr>
							<td><c:out value="${issuebook.id}" /></td>
							<td><c:out value="${issuebook.bookName}" /></td>
							<td><c:out value="${issuebook.studentName}" /></td>
							<td><c:out value="${issuebook.studentNo}" /></td>
							<td><c:out value="${issuebook.issueDate}" /></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
<%@include file="fragment/footer.jsp" %>