$('#signup-form').on('submit', function(e) {
    e.preventDefault(); // 기본 폼 제출 막기

    const data = {
        info: $('#info').val(),
        fullName: $('#fullName').val(),
        userName: $('#userName').val(),
        password: $('#password').val()
    };

    $.ajax({
        type: 'POST',
        url: '/api/signup', // 백엔드의 회원가입 엔드포인트 주소
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(response) {
            alert('회원가입 성공!');
            window.location.href="/login"
        },
        error: function(xhr) {
            alert('회원가입 실패: ' + xhr.responseText);
        }
    });
});