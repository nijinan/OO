var name=
new Array(
new Array("松软面包","白面包","巨菜叶"),
new Array("牛肉","鸡腿肉","鳕鱼肉","虾肉"),
new Array("生菜","番茄","辣椒圈","洋葱"),
new Array("黄芝士","白芝士","芝士条"),
new Array("芥末酱","蛋黄酱","烧烤酱","香辣酱","千岛酱","番茄酱"),
new Array("培根","牛油果泥","玉米脆片","香煎蘑菇","煎蛋"),
)

function F() {
    var url = "";
    var param = {
        "id" : 2,
    };
    var success = function(data) {
        // do sth
        var jsonData = eval("(" + data + ")");
    };
    $.post(url, param, success);
}