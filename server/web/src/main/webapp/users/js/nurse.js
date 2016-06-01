/**
 * Created by CJ on 6/1/16.
 */

$(
    function () {
        jQuery('#nurseTable').dataTable({
            language: {
                url: dataTable_localisation_url
            },
            sPaginationType: "full_numbers"
        });
    }
);