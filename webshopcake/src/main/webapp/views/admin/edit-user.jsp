<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/template/admin" var="url"></c:url>
<!DOCTYPE html>
<html>
  <head>
    <script src="${url}/js/ckeditor.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit User</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link
      href="http://fonts.googleapis.com/css?family=Open+Sans"
      rel="stylesheet"
      type="text/css"
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
              <h2>Sửa thông tin người dùng</h2>
              <h5>Bạn có thể sửa thông tin người dùng ở đây</h5>
            </div>
          </div>
          <!-- /. ROW  -->
          <hr />
          <div class="row">
            <div class="col-md-12">
              <!-- Form Elements -->
              <div class="panel panel-default">
                <div class="panel-heading">Sửa thông tin người dùng</div>
                <div class="panel-body">
                  <div class="row">
                    <div class="col-md-6">
                      <form
                        role="form"
                        action="${pageContext.request.contextPath }/edit-user"
                        method="post"
                        enctype="multipart/form-data"
                      >
                        <input
                          name="id"
                          value="${user.getUserId() }"
                          hidden=""
                        />
                        <div class="form-group">
                          <label>Tên tài khoản:</label>
                          <input
                            class="form-control"
                            value="${user.getUserName() }"
                            name="username"
                          />
                        </div>
                        <div class="form-group">
                          <label>Mật khẩu</label>
                          <input
                            class="form-control"
                            value="${user.getPassword() }"
                            type="text"
                            name="password"
                          />
                        </div>
                        <div class="form-group">
                          <label>Họ tên</label>
                          <input
                            class="form-control"
                            value="${user.getFullName() }"
                            type="text"
                            name="fullname"
                          />
                        </div>
                        <div class="form-group">
                          <label>Role ID</label>
                          <input
                              class="form-control"
                              value="${user.getRoleId() }"
                              type="number"
                              name="roleid"
                              min="0"
                              max="1"
                            />
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input
                              class="form-control"
                              value="${user.getGmail() }"
                              type="email"
                              name="email"
                            />
                        </div>
                        <button type="submit" class="btn btn-default">
                          Sửa
                        </button>
                        <button type="reset" class="btn btn-primary">
                          Làm mới
                        </button>
                      </form>
                      <div class="alert alert-primary" role="alert">
                        <strong>${thongBao}</strong>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Form Elements -->
            </div>
          </div>
          <!-- /. ROW  -->
          <div class="row">
            <div class="col-md-12"></div>
          </div>
          <!-- /. ROW  -->
        </div>
        <!-- /. PAGE INNER  -->
      </div>
      <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="${url}/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="${url}/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="${url}/js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="${url}/js/custom.js"></script>
    <script type="text/javascript" language="javascript">
      CKEDITOR.replace("editer", { width: "700px", height: "300px" });
    </script>
  </body>
</html>
