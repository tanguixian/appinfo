$(function() {
	// 动态加载所属平台列表
	$.ajax({
		type : "GET",// 请求类型
		url : "/AppInfoSystem/data_diciontary/Statuslsit.do",// 请求的url
		data : {
			tcode : "APP_FLATFORM"
		},// 请求参数
		dataType : "json",// ajax接口（请求url）返回的数据类型
		success : function(data) {// data：返回数据（json对象）
			$("#flatformId").html("");
			var options = "<option value=\"\">--请选择--</option>";
			for (var i = 0; i < data.length; i++) {
				options += "<option value=\"" + data[i].valueId + "\">"
						+ data[i].valueName + "</option>";
			}
			$("#flatformId").html(options);
		},
		error : function(data) {// 当访问时候，404，500 等非200的错误状态码
			alert("加载平台列表失败！");
		}
	});
	// 动态加载一级分类列表
	$.ajax({
		type : "GET",// 请求类型
		url : "/AppInfoSystem/app_category/Catelinkage.do",// 请求的url
		data:{pid:null},//请求参数
		dataType : "json",// ajax接口（请求url）返回的数据类型
		success : function(data) {// data：返回数据（json对象）
			$("#categoryLevel1").html("");
			var options = "<option value=\"\">--请选择--</option>";
			for (var i = 0; i < data.length; i++) {
				options += "<option value=\"" + data[i].id + "\">"
						+ data[i].categoryName + "</option>";
			}
			$("#categoryLevel1").html(options);
		},
		error : function(data) {// 当访问时候，404，500 等非200的错误状态码
			alert("加载一级分类列表失败！");
		}
	});
	// 动态加载二级分类列表
	$("#categoryLevel1")
			.change(
					function() {
						var categoryLevel1 = $("#categoryLevel1").val();
						if (categoryLevel1 != '' && categoryLevel1 != null) {
							$
									.ajax({
										type : "GET",// 请求类型
										url : "/AppInfoSystem/app_category/Catelinkage.do",// 请求的url
										data : {
											pid : categoryLevel1
										},// 请求参数
										dataType : "json",// ajax接口（请求url）返回的数据类型
										success : function(data) {// data：返回数据（json对象）
											$("#categoryLevel2").html("");
											var options = "<option value=\"\">--请选择--</option>";
											for (var i = 0; i < data.length; i++) {
												options += "<option value=\""
														+ data[i].id + "\">"
														+ data[i].categoryName
														+ "</option>";
											}
											$("#categoryLevel2").html(options);
										},
										error : function(data) {// 当访问时候，404，500
											// 等非200的错误状态码
											alert("加载二级分类失败！");
										}
									});
						} else {
							$("#categoryLevel2").html("");
							var options = "<option value=\"\">--请选择--</option>";
							$("#categoryLevel2").html(options);
						}
						$("#categoryLevel3").html("");
						var options = "<option value=\"\">--请选择--</option>";
						$("#categoryLevel3").html(options);
					});
	// 动态加载三级分类列表
	$("#categoryLevel2")
			.change(
					function() {
						var categoryLevel2 = $("#categoryLevel2").val();
						if (categoryLevel2 != '' && categoryLevel2 != null) {
							$
									.ajax({
										type : "GET",// 请求类型
										url : "/AppInfoSystem/app_category/Catelinkage.do",// 请求的url
										data : {
											pid : categoryLevel2
										},// 请求参数
										dataType : "json",// ajax接口（请求url）返回的数据类型
										success : function(data) {// data：返回数据（json对象）
											$("#categoryLevel3").html("");
											var options = "<option value=\"\">--请选择--</option>";
											for (var i = 0; i < data.length; i++) {
												options += "<option value=\""
														+ data[i].id + "\">"
														+ data[i].categoryName
														+ "</option>";
											}
											$("#categoryLevel3").html(options);
										},
										error : function(data) {// 当访问时候，404，500
											// 等非200的错误状态码
											alert("加载三级分类失败！");
										}
									});
						} else {
							$("#categoryLevel3").html("");
							var options = "<option value=\"\">--请选择--</option>";
							$("#categoryLevel3").html(options);
						}
					});

	$("#back").on("click", function() {
		window.location.href = "list";
	});

	$("#APKName").bind("blur",function() {
				// ajax后台验证--APKName是否已存在
		var AKPName =$("#APKName").val();
		if(AKPName!=null&&AKPName!=""){
			$.ajax({
				type : "GET",// 请求类型 ,//请求的url
				url:"/AppInfoSystem/appinfo/validateAPKName.do",
				data : {
					APKName : $("#APKName").val()
				},// 请求参数

				success : function(data) {// data：返回数据（json对象）
					
					if (data == "exist") {// 账号不可用，错误提示
						alert("该APKName已存在，不能使用！");
					}
				},error:function(data){
					alert("错误请求");
				}
			});
		}
		

	});

});
