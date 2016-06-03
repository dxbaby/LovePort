/**
 * Created by CJ on 6/3/16.
 */

$(function () {
    $("#passwordForm").validate({
        ignoreTitle: true,
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        success: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
            $(element).remove();
        },
        onfocusout: function (element) {
            $(element).valid();
        },
        rules: {
            password: {
                required: true,
                minlength: 5
            },
            confirmPassword: {
                minlength: 5,
                equalTo: "#password"
            }
        }
    });
});