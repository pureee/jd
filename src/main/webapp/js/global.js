/**
 * 全局JS
 */
function changeCode() {
    var a = Math.round(Math.random() * 40);
    $('.img_code').attr('src', '/verifyController/getVerifyCodeImg.do?a=' + a)
}
