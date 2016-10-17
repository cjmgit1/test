

function nicknameCheck(){
    
	var name = getValue("user.nickname");
	bbs.nicknameCheck(name,process);
}

function getValue(obj){
	
	return document.getElementById(obj).value;

}

function process(data){

	
	dwr.util.setValue("unickname",data);
	if(data=="该用户名已经被使用"){
		document.all.submit.disabled=true;
	}else{
		document.all.submit.disabled = false;
	}

}	

function refurbish(obj){
	obj.src="../../check";
}

function refurbish2(obj){
	obj.src="../../../check";
}

function showComment(obj){
	
	
	var div = document.getElementById(obj);
	var button = document.getElementById("commentButton");
	div.style.display=div.style.display=="none"?"block":"none";
	button.value=button.value=="我要评论"?"关闭评论":"我要评论";
	document.getElementById("rcontents").value="";

}

function shwInfo(topic,nickname,ttime,rsize,tcontents){
	
	var div = document.getElementById("shw");
	
	div.style.display = "block";
	div.style.pixelTop = event.y;
	div.style.pixelLeft = event.x+20;
	div.style.position ="absolute";
	document.getElementById("stopic").innerHTML=topic;
	document.getElementById("suser").innerHTML=nickname;
	document.getElementById("stime").innerHTML=ttime;
	document.getElementById("srsize").innerHTML=rsize;
	document.getElementById("rtcontents").innerHTML=tcontents;

}

function hid(){
	var div = document.getElementById("shw");
	div.style.display="none";
}


///////////////////////////////////日历

  var calendar = null;

  function calSelected(cal, date) {
    cal.sel.value = date;

    var updateFlexElements = document.getElementsByName('updateF' + cal.sel.name.substring(1));
    if ((typeof updateFlexElements != "undefined") && (updateFlexElements.length > 0)) {
	var elem = updateFlexElements[0];
	if (elem.type == "checkbox") {
	   elem.checked = true;
	}
    }
    cal.callCloseHandler();
  } // calSelected

  function calCloseHandler(cal) {
   cal.hide();
  } // calCloseHandler

  function calShow(id) {
    var el = document.getElementById(id);
    if (calendar != null) {
      calendar.hide();		// hide the existing calendar
      calendar.parseDate(el.value); // set it to a new date
    } else {
      var cal = new Calendar(false, null, calSelected, calCloseHandler);
      var now = new Date();
      calendar = cal;
      //calendar.setDateFormat('mm/dd/y');
      calendar.setDateFormat('y-mm-dd');
      calendar.setRange(now.getFullYear() - 10, now.getFullYear() + 10);
      calendar.weekNumbers = false;
      calendar.create();
    }
    calendar.sel = el;
    calendar.showAtElement(el);
    //calendar.addEvent(document, "mousedown", checkCalendar);
    return false;
  } // calShow









