/**
 * Created by CJ on 6/1/16.
 */

$(
    function () {

        $('#nurseForm').validate({
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
                username: {
                    required: true,
                    minlength: 3
                },
                password: {
                    required: true,
                    minlength: 5
                }
            }
        });

        jQuery('#nurseTable').dataTable({
            language: {
                url: dataTable_localisation_url
            },
            sPaginationType: "full_numbers"
        });
    }
);