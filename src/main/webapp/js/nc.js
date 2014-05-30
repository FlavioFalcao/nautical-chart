$(function() {
	// 初始化页面
	getProjects();
	// 初始化提交按钮
	initSumbits();

	// projects li的click函数
	function projectClick() {
		emptyIssues();
		emptyVersions();

		getVersions();
	}

	// 新增project函数
	function addProject() {
		// 清理现场
		emptyIssues();
		emptyVersions();
		emptyProjects();

		popupMask();
		popDiv('newproject');
		getProjects();
	}

	// 显示project详细
	function showProjectDetail() {
		var detail = $("<span></span>").text(" detail");
		detail.click(function() {alert("TEST");});
		$(this).append(detail);
	}

	// 隐藏project详细
	function hideProjectDetail() {
		$(this).children().next().remove();
	}

	// versions li的click函数
	function versionClick() {
		emptyIssues();

		getIssues();
	}

	// 新增version函数
	function addVersion() {
		// 清理现场
		emptyIssues();
		emptyVersions();

		popupMask();
		popDiv('newversion');
		getVersions();
	}
	
	// 显示version详细
	function showVersionDetail() {
		var detail = $("<span></span>").text(" detail");
		$(this).append(detail);
	}

	// 隐藏version详细
	function hideVersionDetail() {
		$(this).children().next().remove();
	}

	// issue li的click函数
	function issueClick() {
		var version = $(this).text();

		// 清理现场
		emptyIssues();

		popupMask();
		popDiv('newissue');
		getIssues();
	}

	// 清空projects
	function emptyProjects() {
		$("#projects").empty();
	}

	// 从服务端获取projects
	function getProjects() {
		$.get("ajax.do", {
			"type" : "projects"
		}, function(projects, status) {
			showProjects(projects);
		}, "json");
	}

	// 显示projects
	function showProjects(projects) {
		for (var i = 0; i < projects.length; i++) {
			var content = $("<span></span>").text(projects[i]);
			content.click(projectClick);
			var newNode = $("<div></div>");
			newNode.mouseenter(showProjectDetail);
			newNode.mouseleave(hideProjectDetail);
			newNode.append(content);
			$("#projects").append(newNode);
		}

		// 增加Add Project
		var newNode = $("<div></div>").text("Add Project");
		newNode.bind("click", addProject);
		$("#projects").append(newNode);
	}

	// 清空versions
	function emptyVersions() {
		$("#versions").empty();
	}

	// 从服务端获取versions
	function getVersions() {
		$.get("ajax.do", {
			"type" : "versions"
		}, function(versions, status) {
			showVersions(versions);
		}, "json");
	}

	// 显示versions
	function showVersions(versions) {
		for (var i = 0; i < versions.length; i++) {
			var newNode = $("<div></div>").text(versions[i].name);
			newNode.click(versionClick);
			$("#versions").append(newNode);
		}

		// 增加Add Project
		var newNode = $("<div></div>").text("Add Version");
		newNode.click(addVersion);
		$("#versions").append(newNode);
	}

	// 清空issues
	function emptyIssues() {
		$("#issues").empty();
	}

	// 从服务端获取issues
	function getIssues() {
		$.get("ajax.do", {
			"type" : "issues"
		}, function(issues, status) {
			showIssues(issues);
		}, "json");
	}

	// 显示issues
	function showIssues(issues) {
		for ( var i in issues) {
			var newNode = $("<div></div>").text(issues[i].name);
			newNode.bind("click", issueClick);
			$("#issues").append(newNode);
		}

		// 增加Add Project
		var newNode = $("<div></div>").text("Add Issue");
		newNode.bind("click", issueClick);
		$("#issues").append(newNode);
	}

	// 显示隐藏层
	function popupMask() {
		var windowWidth = document.body.clientWidth;
		var windowHeight = document.body.clientHeight;

		// 添加并显示遮罩层
		$("<div id='mask'></div>").addClass("mask").width(windowWidth).height(
				windowHeight).click(function() {
			removeMask();
			hideDiv();
		}).appendTo("body").fadeIn(200);
	}

	// 删除隐藏层
	function removeMask() {
		$("#mask").remove();
	}

	// 显示新增div
	function popDiv(div_id) {
		var div_obj = $("#" + div_id);
		var windowWidth = document.body.clientWidth;
		var windowHeight = document.body.clientHeight;
		var popupHeight = div_obj.height();
		var popupWidth = div_obj.width();
		div_obj.css({
			"position" : "absolute"
		}).animate({
			left : windowWidth / 2 - popupWidth / 2,
			top : windowHeight / 2 - popupHeight / 2,
			opacity : "show"
		}, "slow");
	}

	// 隐藏新增div
	function hideDiv() {
		$("#newproject").animate({
			right : 0,
			button : 0,
			opacity : "hide"
		});
		$("#newversion").animate({
			right : 0,
			button : 0,
			opacity : "hide"
		});
		$("#newissue").animate({
			right : 0,
			button : 0,
			opacity : "hide"
		});
	}

	function initSumbits() {
		$("#projectsubmit").click(function() {
			alert("projectsubmit");
		});
		$("#versionsubmit").click(function() {
			alert("versionsubmit");
		});
		$("#issuesubmit").click(function() {
			alert("issuesubmit");
		});
	}

	// $("input[type=text]").hover(function() {
	// var txt_value = $(this).val();
	//
	// if (txt_value == "input here") {
	// $(this).val("");
	// }
	// }, function() {
	// var txt_val = $(this).val();
	// if (txt_val == "") {
	// $(this).val("input here");
	// }
	// });
	//
	// $("input[type=button]").click(function() {
	// $.get("ajax.do", function(data, status) {
	// $("#resText").text(data);
	// }, "text");
	// });
});
