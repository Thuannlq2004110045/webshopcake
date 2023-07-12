<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/common/taglib.jsp"%>
<c:url value="template/admin" var="url"></c:url>
<nav class="navbar-default navbar-side" role="navigation">
  <div class="sidebar-collapse">
    <ul class="nav" id="main-menu">
      <li class="text-center">
        <img src="${url}/img/find_user.png" class="user-image img-responsive" />
      </li>

      <li>
        <a href="${pageContext.request.contextPath }/admin-trangchu"
          ><i class="fa fa-dashboard fa-3x"></i> Trang chủ Admin</a
        >
      </li>
      <li>
        <a href="${pageContext.request.contextPath }/admin-product-list"
          ><i class="fa fa-desktop fa-3x"></i> Quản lý sản phẩm</a
        >
      </li>
      <li>
        <a href="${pageContext.request.contextPath }/add-product"
          ><i class="fa fa-bar-chart-o fa-3x"></i> Thêm sản phẩm</a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath }/admin-user-list"><i class="fa fa-qrcode fa-3x"></i>Quản lý người dùng</a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath }/add-user"><i class="fa fa-bar-chart-o fa-3x"></i>Thêm người dùng</a>
      </li>
    </ul>
  </div>
</nav>
<script>
  // Lấy đường dẫn hiện tại của trang
var currentPath = window.location.pathname;

// Lặp qua từng liên kết trong danh sách
var links = document.querySelectorAll(".nav li a");
links.forEach(function(link) {
  // Lấy đường dẫn của liên kết
  var href = link.getAttribute("href");

  // So sánh đường dẫn hiện tại với đường dẫn của liên kết
  if (href === currentPath) {
    // Thêm lớp "active-menu" vào liên kết
    link.classList.add("active-menu");
  }
});

</script>
