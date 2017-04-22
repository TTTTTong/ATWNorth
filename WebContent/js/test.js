/**
 * 
 */
$(function () {  
        var ie6 = /msie 6/i.test(navigator.userAgent)  
        , dv = $('header'), st;  
        dv.attr('otop', dv.offset().top); //存储原来的距离顶部的距离  
        $(window).scroll(function () {  
            st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);  
            if (st >= parseInt(dv.attr('otop'))) {  
                if (ie6) {//IE6不支持fixed属性，所以只能靠设置position为absolute和top实现此效果  
                    dv.css({ position: 'absolute', top: st });  
                }  //其他浏览器则直接加上fixed属性
                else if (dv.css('position') != 'fixed') dv.css({ 'position': 'fixed', top: 0 });  
            } else if (dv.css('position') != 'static') dv.css({ 'position': 'static' });  
        });  
    });