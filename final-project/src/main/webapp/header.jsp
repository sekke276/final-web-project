 <div class="header">
    <div class="container">
        <div class="first-section">
            <div class="btn-change-shopping-container">
                <div class="btn-change-shopping">
                    <span  class="strike"></span>
                    <span  class="strike"></span>
                    <span class="strike"></span>

                    <div class="plant-change">
                        <a href = "salingProduct">Plants</a>
                    </div>
                </div>

            </div>

            <div class="group-logo">
                <a href="./index.jsp" class="logo-link">
                    <img src="icon_web/2073.jpg" alt="Group logo" id = "logo-img"/>
                <span id = "group-name">DINOSAUR</span>  
                </a>
            </div>
        </div>
        <div class="nav-contents">
            <div class="list-nav">
                <ul class="list-contain">
                    <li class ="list-content"><a href="./index.jsp">HOME</a></li>
                    <li class = "list-content"><a href="./index.jsp#categories">CATEGORIES</a></li>
                    <li class = "list-content"><a href="./index.jsp#featured">PRODUCTS</a></li>
                    <li class = "list-content"><a href="./index.jsp#service">SERVICE</a></li>
                </ul>
            </div>
            <form action="salingProduct" class="input-container">
                <input oninput="searchProductByName(this)" 
					name="searchName" 
					type="text" 
					id="search-header" 
					list="search-list" 
					placeholder="Search" 
					class="input-search" 
					size="25"/>
                <datalist id = "search-list">
                </datalist>
                <input type="hidden" name="action" value="searchItem">
				<input type="image" class="search-btn" src="./icon_web/loupe.png"  alt="Submit">
            </form>
			<c:choose>
				<c:when test = "${sessionScope.user != null}">
					<a href="Cartlist" class="icon-link">
						<div class="nav-icon-container">
							<img src="icon_web/shopping-cart.png" alt="shopping cart" class = "nav-icon">
						</div>
					</a>
					<div href="#" class="icon-link " id = "user-login">
						<div class="nav-icon-container ">
							<img src="icon_web/user.png" alt="User" class = "nav-icon">
							<div class="user-control" id = "user-control">
								<a href="personalInformation" class="user-control-content">Personal Information</a>
								<a href="ListPaymentHistory" class="user-control-content">Purchase History</a>
							<c:if test = "${sessionScope.user.admin == 1}">
								<a href="productManagement" class="user-control-content">Manage Product</a>
							</c:if> 
							<a class="user-control-content" href="logout">Log Out</a>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="login-container">
					<a href="./login.jsp" class="login">Login</a>
					<span>&nbsp; / &nbsp;</span> 
					<a href="./register.jsp" class="login">SignUp</a>
				</div>
				</c:otherwise>
			</c:choose>
        </div>
        
        <!--left nav-->
            <input type = "checkbox" id = "nav-input" class="nav__input">
            <label for="nav-input">
				<div class = "open-nav-logo">
					<div class="line"></div>
					<div class="line"></div>
					<div class="line"></div>
				</div>
			</label>

            <label for = "nav-input" class = "overplayed"></label>
            <!--Nav left-->
            <div class = "left-nav">
                <div id = "nav-header">
					<div class = "user-login-container">
						<c:if test = "${sessionScope.user != null}">
							<a href="Cartlist" class="icon-link">
								<div class="nav-icon-container cart-mobile">
									<img src="icon_web/shopping-cart.png" alt="shopping cart" class = "nav-icon">
								</div>
							</a>
							<div href="#" class="icon-link " id = "user-login">
								<div class="nav-icon-container user-container-mobile">
									<img src="icon_web/user.png" alt="User" class = "nav-icon">
									<div class="user-control" id = "user-control">
										<a href="personalInformation" class="user-control-content">Personal Information</a>
										<a class="user-control-content">Purchase History</a>
									<c:if test = "${sessionScope.user.admin == 1}">
										<a href="productManagement" class="user-control-content">Manage Product</a>
									</c:if> 
									<a class="user-control-content" href="logout">Log Out</a>
									</div>
								</div>
							</div>
						</c:if>
					</div>
                    <label for="nav-input">
						<div class = "close-nav">
							<div class="line" id = "line1"></div>
							<div class="line" id = "line2"></div>
						</div>
					</label>
                </div>
                <div class="nav-content">
                    <div class="list-nav mobile">
                        <form action="" class="input-container">
                            <input type="text" id="search-header" placeholder="Search" class = "input-search" size="25" oninput="searchProductByName(this)"/>
                            <datalist id = "search-header">
                            </datalist> 
							<input type="image" class="search-btn" src="./icon_web/loupe.png"  alt="Submit">
                        </form>
                        <ul class="list-contain moblie">
                            <li class ="list-content"><a href="./index.jsp">HOME</a></li>
                            <li class = "list-content"><a href="./index.jsp#categories">CATEGORIES</a></li>
                            <li class = "list-content"><a href="./index.jsp#featured">PRODUCTS</a></li>
                            <li class = "list-content"><a href="./index.jsp#service">SERVICE</a></li>
                        </ul> 
                    </div>
					<c:if test = "${sessionScope.user == null}">
						<div class="login-container">
							<a href="./login.jsp" class="login">Login</a>
							<span>&nbsp; / &nbsp;</span> 
							<a href="./register.jsp" class="login">SignUp</a>
						</div>
					</c:if>
                </div>
            </div>
		<!--end left nav-->
        </div>
    </div>
</div>
<c:if test = "${sessionScope.user != null}">
<script type="text/javascript">
	(function(d, m){
		var kommunicateSettings = 
			{"appId":"1f09ac23e94291f2167f08c4e8158ca8d","popupWidget":true,"automaticChatOpenOnNavigation":true,
			"onInit": function () {
				var events = {
					'onMessageReceived': function (resp)
					{
						var checkMessage = resp.message.message?.slice(0,7);
						if(checkMessage === "Alright")
						{
							var amount = resp.message.message.replace(/[^0-9]/g, '');
							var plantName = resp.message.message.split(' ')
							.slice(0,-6).slice(2).join(" ").replace(/"/g,'');
							$.ajax(
								{
								url : "botServlet",
								type: "POST",
								data:{
									action: "addToCart",
									plantName: plantName,
									amount: amount
								},
								success: function(data){}
								}
							)
						}

					//called when a new message is received
					},
					'onRichMessageButtonClick': function (resp)
					{
						if(resp.eventLabel === "Bonsai" || resp.eventLabel === "Air Purifying Plant"
						|| resp.eventLabel === "Climber" || resp.eventLabel === "Flowering")
						{
							$.ajax({
								url : "botServlet",
								type: "POST",
								data:{
									action: "filter",
									type: resp.eventLabel
								},
								success: function(data)
								{
									var link = "https://final-web-pro.herokuapp.com/filter" + "?" + data
									console.log(data);
									window.location =  link;
								}
								})
						}
						else if (resp.eventLabel === "Empty my cart")
						{
							$.ajax({
								url : "botServlet",
								type: "POST",
								data:{
									action: "Empty my cart"
								},
								success: function(data){}
								})
						}
					}
				};
				Kommunicate.subscribeToEvents(events);
			},
		};
		var s = document.createElement("script"); s.type = "text/javascript"; s.async = true;
		s.src = "https://widget.kommunicate.io/v2/kommunicate.app";
		var h = document.getElementsByTagName("head")[0]; h.appendChild(s);
		window.kommunicate = m; m._globals = kommunicateSettings;
		
	})(document, window.kommunicate || {});
/* NOTE : Use web server to view HTML files as real-time update will not work if you directly open the HTML file in the browser. */
</script>
</c:if>