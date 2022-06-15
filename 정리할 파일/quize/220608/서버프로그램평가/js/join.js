function infoConfirm(){
	if(join_frm.cid.value.length<3){
		alert('아이디는 반드시 3글자 이상');
		join_frm.cid.focus();
		return;
	}
	if(!join_frm.cpw.value){
		alert('비밀번호는 필수 입력 사항입니다');
		join_frm.cpw.focus();
		return;
	}
	if(join_frm.cpw.value!=join_frm.pwChk.value){
		alert('비밀번호를 확인하세요');
		join_frm.cpw.focus();
		return;
	}
	if(!join_frm.cname.value){
		alert('이름은 필수 입력 사항입니다');
		join_frm.name.focus();
		return;
	}
	join_frm.submit(); // 강제로 submit 이벤트 발생
}

