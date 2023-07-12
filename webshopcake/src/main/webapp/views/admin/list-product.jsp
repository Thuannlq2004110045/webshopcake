<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:url value="/template/admin" var="url"></c:url>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Quản lý bánh</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- MORRIS CHART STYLES-->

    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link
      href="http://fonts.googleapis.com/css?family=Open+Sans"
      rel="stylesheet"
      type="text/css"
    />
    <!-- TABLE STYLES-->
    <link
      href="${url}/js/dataTables/dataTables.bootstrap.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <div id="wrapper">
      <jsp:include page="/views/admin/nav-bar.jsp"></jsp:include>

      <!-- /. NAV TOP  -->
      <jsp:include page="/views/admin/slide-bar.jsp"></jsp:include>
      <!-- /. NAV SIDE  -->
      <div id="page-wrapper">
        <div id="page-inner">
          <div class="row">
            <div class="col-md-12">
              <h2>Tất cả bánh</h2>
              <h5>Bạn có thể quản lý bánh ở đây</h5>
            </div>
          </div>
          <!-- /. ROW  -->
          <hr />

          <div class="row">
            <div class="col-md-12">
              <!-- Advanced Tables -->
              <div class="panel panel-default">
                <div class="panel-heading">Quản lý bánh</div>
                <div class="panel-body">
                  <div class="table-responsive">
                    <table
                      class="table table-striped table-bordered table-hover"
                      id="dataTables-example"
                    >
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>Ảnh</th>
                          <th>Tên bánh</th>
                          <th>Giá</th>
                          <th>Loại</th>
                          <th>Mô tả</th>
                          <th>Thao tác</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${proList }" var="pro">
                          <tr class="odd gradeX">
                            <td>${pro.cakeId }</td>

                            <td>
                              <img
                                height="150"
                                width="200"
                                src="template/client/images/${pro.thumbnail}"
                              />
                            </td>

                            <td>${pro.cakeName }</td>
                            <td>${pro.price }</td>
                            <td>${pro.category.name }</td>
                            <td>${pro.content }</td>
                            <td>
                              <a
                                href="<c:url value='/edit-product?id=${pro.cakeId }'/>"
                                class="center"
                                >Sửa</a
                              >
                              |
                              <a
                                href="<c:url value='/delete-cake?cakeId=${pro.cakeId }'/>"
                                class="center"
                                >Xóa</a
                              >
                            </td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <!--End Advanced Tables -->
            </div>
          </div>
        </div>
      </div>
      <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
    <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="${url}/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="${url}/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="${url}/js/jquery.metisMenu.js"></script>
    <!-- DATA TABLE SCRIPTS -->
    <script src="${url}/js/dataTables/jquery.dataTables.js"></script>
    <script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
      $(document).ready(function () {
        $("#dataTables-example").dataTable();
      });
    </script>
    <!-- CUSTOM SCRIPTS -->
    <script src="${url}/js/custom.js"></script>
  </body>
</html>
