<%@include file="Includes/header.jsp" %>

=		<main class="mdl-layout__content">
			<div class="mdl-card mdl-shadow--6dp">
				<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
					<h2 class="mdl-card__title-text">Log In SupBartering</h2>
				</div>
			  	<div class="mdl-card__supporting-text">
					<form action="login">
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="text" id="login_username" />
							<label class="mdl-textfield__label" for="login_username">Username</label>
						</div>
						<div class="mdl-textfield mdl-js-textfield">
							<input class="mdl-textfield__input" type="password" id="login_password" />
							<label class="mdl-textfield__label" for="login_password">Password</label>
						</div>
					</form>
				</div>
				<div class="mdl-card__actions mdl-card--border">
					<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Log in</button>
				</div>
			</div>
		</main>

<%@include file="Includes/footer.jsp" %>