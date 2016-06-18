/**
 * Created by CJ on 6/18/16.
 */

$(function () {

    // 增加查询病人动作
    $('#patientChecker').click(function () {
        var checkForID = $('input[name=checkForID]');
        var val = checkForID.val();
        if (val.length != 18) {
            checkForID.focus();
            return false;
        }

        $.ajax({
            url: queryCorePatientUrl + "?id=" + val,
            error: function () {
                showDanger('错误', '获取数据失败');
            },
            success: function (data) {
                var addPatient = $('#addPatient');
                $.each(data, function (index, value) {
                    $('*[name=' + index + ']').val('' + value);
                });
                addPatient.show();
            }
        });

        return false;
    });

    // 校验
    $('#addPatientForm').validate({
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
            name: {
                required: true,
                minlength: 2
            },
            sex: {
                required: true
            },
            nationality: {
                required: true
            },
            code: {
                required: true,
                minlength: 10
            },
            censusType: {
                required: true
            },
            culture: {
                required: true
            },
            identityCode: {
                required: true,
                minlength: 16
            },
            marriage: {
                required: true
            },
            birth: {
                required: true
            },
            disabilityCode: {
                required: true,
                minlength: 18
            },
            mobile: {
                required: true
            },
            phone: {
                required: true
            },
            address: {
                required: true
            }
        }
    });
    // table
    jQuery('#patientTable').dataTable({
        language: {
            url: dataTable_localisation_url
        },
        sPaginationType: "full_numbers"
    });
});
