<!DOCTYPE html>
<html lang="en">
    <head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="./Components/reset.css">
		<link rel="stylesheet" href="./Components/global.css">
		<link rel="stylesheet" href="./Components/Header/nav-pc.css">
		<link rel="stylesheet" href="./Components/Header/left-nav.css">
		<link rel="stylesheet" href="./Components/Cart/cart.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="./Components/js/searchProductByName.js"></script>
		<script src="./Components/js/paypal.js"></script>
		<script src="https://www.paypal.com/sdk/js?client-id=Ac168FfjHNa-SERjcKvfUyowKz5w5_6q5yc9w7CEU-7PnbgqXalljT3oXhE1dulK63sHHoC90ZXC7As8"></script>
		<title>dinosaur</title>
		<link rel = "icon" href = "./icon_web/2073.jpg" type = "image/x-icon">
	</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ include file = "./header.jsp"%>
	<div class="cart-section">
		<div class="cart-container">
			<div class="cart">
				<div class="my-cart-body-title">
					<div class="my-cart-tilte item-detail">Item(s) Details</div>
					<div class="my-cart-title item-quality title-quality" >Quanlity</div>
					<div class="my-cart-title total">Total</div>
				</div>
				<c:forEach var = "p" items = "${listItems}" varStatus="status">
				<div class="my-cart-body">
					<div class="item-detail">
						<div class="item-img-container">
							<img src="${listTrees[status.index].getTreeImg()}" alt="" class="item-img">
						</div>
						<div class="item-description">
							<a href="#" class = "item-link"><div class="item-title"><c:out value = "${listTrees[status.index].getTreeName()}"/></div></a>
							<span class = "item-title price"><c:out value = "${listTrees[status.index].getPrice()}"></c:out> $</span>
						</div>
					</div>
					<div class="day-paid-container">
						<span class="day-paid"><c:out value = "${p.getDayPaid()}"/></span>
					</div>
					<div class="item-quality">
					<div  id="Quality"  >
						<span class="amount"><c:out value = "${p.getQuality()}"></c:out></span>
					</div>
				</div>
				<div class="total">
					<span ><c:out value = "${p.getPrice()}"/> $</span>
				</div>
				</div>
				</c:forEach>

			</div>
		</div>
		
	</div>
</body>
</html>