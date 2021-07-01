/**
 * 
 */

function success() {
	let mall = "${sessionScope.mallAddress}";
	location.href = mall + '?message=success';
}

function fail() {
	let mall = "${sessionScope.mallAddress}";
	location.href = mall + '?message=failed';
}

function disconnect(bankURL) {
	let sendData = {
		"messageType": "disconnect"
	};
	$.ajax({
		url: bankURL,
		contentType: "application/json;charset=UTF-8",
		method: "post",
		data: JSON.stringify(sendData)
	})
}

function paymentway_check() {
	let bankURL = "http://localhost:8081/banking";
	let tempMeans = document.getElementsByClassName('on')[0].innerText;
	let payment_number = "";
	let means = "";
	let password = "";
	let cvc = "";
	let bankCode = document.getElementById('bank').value;
	let pg_code = document.getElementById('pg_code').value;
	let end_date = document.getElementById('end_date').value;
	end_date = end_date.split("/");
	let end_year = end_date[1];
	let end_month = end_date[0];
	switch (bankCode) {
		case "bankA":
			bankURL = "http://localhost:8081/connect";
			break;
	}
	if (tempMeans == "카드") {
		means = 'card';
		payment_number = document.getElementsByName('payment_number')[0].value;
		password = document.getElementsByName('password')[0].value;
		cvc = document.getElementById("cvc").value;
		end_date = document.getElementById('end_date').value;
	} else {
		means = 'account';
		payment_number = document.getElementsByName('payment_number')[1].value;
		password = document.getElementsByName('password')[1].value;
	}

	let sendData = {
		"messageType": "paymentWayCheck",
		"pg_code": pg_code,
		"mall_ID": "Joongang",
		"means": means,
		"payment_number": payment_number,
		"payment_password": password,
		"end_month": end_month,
		"end_year": end_year,
		"CVC": cvc
	};

	$.ajax({
		url: bankURL,
		method: "post",
		contentType: "application/json;charset=UTF-8",
		data: JSON.stringify(sendData),
		success: function(data) {
			if (data.messageType == "success") {
				disconnect(bankURL);
				success();
			}
			else {
				fail();
			}
		}
	}).fail(function() {
		alert('오류가 발생했습니다.');
		
	})
}


function payment_ajax() {
	let bankURL = "http://localhost:8081/banking";
	let pg_code = document.getElementById('pg_code').value;

	let sendData = {
		"messageType": "connect",
		"pg_code": pg_code,
		"mall_ID": "Joongang"
	};


	$.ajax({
		url: bankURL,
		method: "post",
		data: JSON.stringify(sendData),
		contentType: "application/json; charset=UTF-8",
		success: function(data) {
			if (data.messageType == "success") {
				alert('통신 성공');
				paymentway_check();
			}
			else {
				alert('은행에 접근할 수 없습니다.' + data.messageType);

				return false;
			}
		}

	}).fail(function() {
		alert('알 수 없는 오류로 거래가 중지되었습니다.');
		return false;
	});
}
