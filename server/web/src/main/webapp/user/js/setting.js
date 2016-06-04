/**
 * Created by CJ on 6/4/16.
 */

$(function () {

    function imageUploaded(path, url) {
        var form = $('#changeImageForm');
        $('input', form).val(path);
        // form.submit();
    }

    $('#uploaderTest').click(function () {
        imageUploaded('test.png');
    });

//        $('#imageUploader').dropzone({
//            url:'hehe',
//            dictDefaultMessage:'dalaoed'
//        });
    Dropzone.options.imageUploader = {
        init: function () {
            this.on("success", function (file) {
                imageUploaded(file.xhr.statusText, file.xhr.responseURL);
            })
        }
//            maxFilesize: 1,
//            maxFiles: 1,
//            parallelUploads: 1,
//            dictDefaultMessage: '中文你看如何?'
    };

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
            oldPassword: {
                required: true,
                minlength: 5
            },
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