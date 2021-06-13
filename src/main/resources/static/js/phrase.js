$(function(){
    const phrBtn = document.getElementsByClassName("btn");
    let count_value = 0;

    $("button").click(function() {
        count_value++;
        const phrName = $(this).val();
        const model = {
              "tapCount" : count_value,
              "phrName" : phrName
            };
        console.log(model)

        $.ajax({
              url : '/',
              type : 'POST',
              data : JSON.stringify(model),
              contentType : 'application/json'
        });
    });

    $(".btn").click(function(){
        count_value++;
        if(count_value >= 4){
            phrBtn.disabled = true;
        }
    });
});
