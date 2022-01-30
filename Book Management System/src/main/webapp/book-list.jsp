<%@ include file="fragment/header.jsp"%>

<div class="row">
	<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

	<div class="container">
		<h3 class="text-center">List of Books</h3>
		<hr>
		<div class="container text-left">

			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
				New Book</a>
		</div>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Book Name</th>
					<th>No. of Copies</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="book" items="${listBook}">

					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><c:out value="${book.bookName}" /></td>
						<td><c:out value="${book.bookCopies}" /></td>
						<td><a href="edit?id=<c:out value='${book.id}' />">Edit</a>
							&nbsp; &nbsp; &nbsp; &nbsp; <a 
							href="delete?id=<c:out value='${book.id}' />">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	</div>
</div>
<%@include file="fragment/footer.jsp"%>