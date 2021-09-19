<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Personal Shopper Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Personal Shopper Management </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
                        <li><a href="<%=request.getContextPath()%>/listItem" class="nav-link">Items</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card2">
                    <div class="card2-body">
                        <c:if test="${items != null}">
                            <form action="updateItem" method="post">
                        </c:if>
                        <c:if test="${items == null}">
                            <form action="insertItem" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${items != null}">
                                    Edit Item
                                </c:if>
                                <c:if test="${items == null}">
                                    Add New Item
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${items != null}">
                            <input type="hidden" name="id" value="<c:out value='${items.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Item Name</label> <input type="text" value="<c:out value='${items.itemName}' />" class="form-control" name="itemName" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Quantity</label> <input type="number" value="<c:out value='${items.quantity}' />" class="form-control" name="quantity">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Price</label> <input type="number" value="<c:out value='${items.price}' />" class="form-control" name="price">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>