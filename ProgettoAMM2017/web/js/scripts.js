// TODO
$(document).ready(function()
{
    $("#searchUsersButton").click(
            function(){

                $.ajax({
                    url: "filter.json",
                    data:{
                        action:"search",
                        q: $("#searchUsersText")[0].value
                    },
                    dataType:"json",
                    success: function(data, state){
                        stateSuccess(data);
                    },
                    error: function(data, state){
                        stateFailure(data, state);
                    }
            });
        })
});
    
    
function stateSuccess(data)
{    
    console.log("success");
    $("#elencoPersone ul").empty();
    for(var instance in data){
        $("#elencoPersone ul").append(createElement(data[instance]));
    }
}
    
function stateFailure()
{
    console.log("failure");
    $("#elencoPersone ul").empty();    
    $("#elencoPersone ul").append($("<li>").append("Nessun utente trovato"));    
}
    
function createElement(user)
{
    var img = $("<img>")
            .attr("alt","foto profilo amico")
            .attr("class", "friendPic");
    
    if(user.urlFotoProfilo == null || user.urlFotoProfilo === "")
        img.attr("src", "Assets/ICONS/noProfilePic_icona.svg");     
    else img.attr("src", user.urlFotoProfilo);
    
    var a = $("<a>")
            .append(img)
            .attr("href", "bacheca.html?action=view&owner="+user.id+"&ownerType=user")   
            .append(user.nome+" "+user.cognome);
    
    return $("<li>").append(a);
}

function updateList()
{

    $.ajax({
        url: "filter.json",
        data:{
            action:"search",
            q: $("#searchUsersText")[0].value
        },
        dataType:"json",
        success: function(data, state){
            stateSuccess(data);
        },
        error: function(data, state){
            stateFailure(data, state);
        }
    });

}