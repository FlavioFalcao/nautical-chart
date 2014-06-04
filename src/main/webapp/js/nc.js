$(function() {
	// 从服务端获取projects
	communicate({"type" : "projects"}, showProjects);
	// 初始化提交按钮
	initSumbits();

	// 与服务端通讯
	function communicate(data, callback) {
		removeMask();
		hideDiv();

		$.get("ajax.do", data, function(result, status) {
			callback(result);
		}, "json");
	}

	// 新增、修改、删除project函数
	function modifyProject(type) {
		// 清理现场
		emptyIssues();
		emptyVersions();
		emptyProjects();

		var data = {
			"type" : type,
			"name" : $("#pName").val(),
			"owner" : $("#pOwner").val(),
			"description" : $("#pDescription").val(),
			"document" : $("#pDocument").val(),
			"born" : $("#pBorn").val(),
			"state" : $("#pState").val()
		};

		communicate(data, showProjects);
	}

	// 从服务端获取issues
	function getIssues() {
		var data = {"type" : "issues"};
		communicate(data, showIssues);
	}

	// projects li的click函数
	function projectClick() {
		emptyIssues();
		emptyVersions();

		communicate({"type" : "versions"}, showVersions); // 从服务端获取versions
	}

	// 新增project函数
	function addProject(project) {
		popupMask();
		popDiv('project');
	}

	// 显示project详细
	function showProjectDetail() {
		var detail = $("<span></span>").text(" detail");
		detail.click(function() {
			getContent("project", $(this).parent().attr("id"));
		});
		$(this).append(detail);
	}

	function getContent(type, name) {
		var data = {"type": type, "name": name};
		communicate(data, showProject);
	}

	function showProject(project) {
		$("#pName").val(project.name);
		$("#pOwner").val(project.owner);
		$("#pDescription").val(project.description);
		$("#pDocument").val(project.document);
		$("#pBorn").val(project.born);
		$("#pState").val(project.state);

		popupMask();
		popDiv('project');
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
		communicate({"type" : "versions"}, showProjects); // 从服务端获取versions
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

	// 显示projects
	function showProjects(projects) {
		for (var i = 0; i < projects.length; i++) {
			var content = $("<span></span>").text(projects[i]);
			content.click(projectClick);
			var newNode = $("<div></div>").attr("id", projects[i]);
			newNode.mouseenter(showProjectDetail);
			newNode.mouseleave(hideProjectDetail);
			newNode.append(content);
			$("#projects").append(newNode);
		}

		// 增加Add Project
		var newNode = $("<div></div>").text("Add Project");
		newNode.click(addProject);
		$("#projects").append(newNode);
	}

	// 清空versions
	function emptyVersions() {
		$("#versions").empty();
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
		cleanProject();
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
			"position" : "absolute",
			"opacity" : "show"
		}).animate({
			left : windowWidth / 2 - popupWidth / 2,
			top : windowHeight / 2 - popupHeight / 2,
			opacity : "show"
		}, "slow");
	}

	// 隐藏新增div
	function hideDiv() {
		$("#project").animate({
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
			modifyProject("addProject");
		});
		$("#delProject").click(function() {
			modifyProject("delProject");
		});
		$("#updateProject").click(function() {
			modifyProject("updateProject");
		});
		$("#versionsubmit").click(function() {
			alert("versionsubmit");
		});
		$("#issuesubmit").click(function() {
			alert("issuesubmit");
		});
	}

	function cleanProject() {
		$("#pName").val("");
		$("#pOwner").val("");
		$("#pDescription").val("");
		$("#pDocument").val("");
		$("#pBorn").val("");
		$("#pState").val("");
	}
});
