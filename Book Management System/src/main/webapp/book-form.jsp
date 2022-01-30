<%@ include file="fragment/header.jsp" %>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${book != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${book == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${book != null}">
            			Edit Book
            		</c:if>
						<c:if test="${book == null}">
            			Add New Book
            		</c:if>
					</h2>
				</caption>

				<c:if test="${book != null}">
					<input type="hidden" name="id" value="<c:out value='${book.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Book Name</label> <input type="text"
						value="<c:out value='${book.bookName}' />" class="form-control"
						name="bookName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>No. of Copies</label> <input type="text"
						value="<c:out value='${book.bookCopies}' />" class="form-control"
						name="bookCopies">
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
<%@include file="fragment/footer.jsp" %>