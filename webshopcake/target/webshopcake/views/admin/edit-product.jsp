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
              <h2>Sửa sản phẩm</h2>
              <h5>Bạn có thể sửa sản phẩm muốn bán ở đây</h5>
            </div>
          </div>
          <!-- /. ROW  -->
          <hr />
          <div class="row">
            <div class="col-md-12">
              <!-- Form Elements -->
              <div class="panel panel-default">
                <div class="panel-heading">Sửa sản phẩm</div>
                <div class="panel-body">
                  <div class="row">
                    <div class="col-md-6">
                      <form
                        role="form"
                        action="${pageContext.request.contextPath }/edit-product"
                        method="post"
                        enctype="multipart/form-data"
                      >
                        <input
                          name="id"
                          value="${cake.getCakeId() }"
                          hidden=""
                        />
                        <div class="form-group">
                          <label>Tên bánh:</label>
                          <input
                            class="form-control"
                            value="${cake.getCakeName() }"
                            name="name"
                          />
                        </div>
                        <div class="form-group">
                          <label>Giá (đồng)</label>
                          <input
                            class="form-control"
                            value="${cake.getPrice() }"
                            type="number"
                            name="price"
                          />
                        </div>
                        <div class="form-group">
                          <label>Mô tả </label> <br />
                          <textarea rows="4" cols="50" name="content" id="editer">
${cake.getContent() }</textarea
                          >
                        </div>

                        <div class="form-group">
                          <label>Loại bánh</label>
                          <div class="checkbox">
                            <select name="categoryId">
                              <c:forEach items="${categories}" var="c">
                                <option value="${c.getCategoryId()}">
                                  ${c.getName()}
                                </option>
                              </c:forEach>
                            </select>
                          </div>
                        </div>
                        <div class="form-group">
                          <label>Ảnh</label>
                          <input
                            type="file"
                            name="image"
                            value="${cake.getThumbnail() }"
                          />
                        </div>
                        <button type="submit" class="btn btn-default">
                          Sửa
                        </button>
                        <button type="reset" class="btn btn-primary">
                          Làm mới
                        </button>
                      </form>
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
