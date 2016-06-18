$(function () {
    /*首页点击*/
    $nfocus = $('.focus_points_news');

    $('.m-focus').each(function () {
        var $this = $(this);
        var imgNum = $this.find('.swipe-wrap').children('div').length;
        var cahtml = "";
        for (var i = 0; i < imgNum; i++) {
            cahtml += "<span></span>";
        }
        $this.find('.focus_points').html(cahtml);
        $this.find('.focus_points').find("span").eq(0).addClass("active");
    });

    var elemFous = document.getElementById('slider');

    window.mySwipeBanner = Swipe(elemFous, {
        auto: 3000,
        transitionEnd: function (index, element) {
            $nfocus.children('span').removeClass("active");
            $nfocus.children('span').eq(index).addClass("active");
        }
    });

    var $indexsection = $('.g-indexsection'),
        $indexnav = $('.g-navsection');
    $('.j-opennav').bind('click', function () {
        var $this = $(this);
        if ($this.is('.active')) {
            $indexsection.removeClass('side');
            $indexnav.removeClass('side');
            $this.removeClass('active');
        } else {
            $indexsection.addClass('side');
            $indexnav.addClass('side');
            $this.addClass('active');
        }
    })

})