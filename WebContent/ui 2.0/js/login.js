$('form div input').on('focus', function() {
    if ($(this).val() === "") {
        $(this).prev('label').animate({
            fontSize: 13,
            top: -25
        }, 350);
    }

});
$('form div input').on('blur', function() {
    if ($(this).val() === "") {
        $(this).prev('label').animate({
            fontSize: 17,
            top: 0
        }, 350);
    }
});

// Em An
// 4-4-2017