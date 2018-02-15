

		<div class="ui segment">
			<h3>List of Cars</h3>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<thead>
					<th>ID</th>
					<th>Owner Name</th>
					<th>Last Date</th>
					<th>Car Model</th>
					<th>Car Type</th>
					<th>Kteo Price</th>
				</thead>
				<!-- loop over and print our cars -->
				<c:forEach var="tempCar" items="${cars}">

					<tr>
						<td>${tempCar.id}</td>
						<td>${tempCar.ownerName}</td>
						<td>${tempCar.lastDate}</td>
						<td>${tempCar.carModel}</td>
						<td>${tempCar.carType}</td>
						<td>${tempCar.kteoPrice}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
