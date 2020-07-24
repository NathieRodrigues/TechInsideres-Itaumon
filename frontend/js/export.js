function exportExcel(e) {
    $('td a').each(function (i, item) { 
        $(this).html(`=HYPERLINK\("${$(this).attr("href")}","${$(this).html()}")`);
    })
    var table = document.getElementById("excel");
    var html = table.outerHTML;

    var url = 'data:application/vnd.ms-excel,' + encodeURI(html);
    e.setAttribute("href", url);
    e.setAttribute("download", "data.xls");
    $('td a').each(function (i, item) { 
        const text = $(this).text().replace(`=HYPERLINK\("${$(this).attr("href")}","`, "").replace(`")`, "")
        $(this).html(text);
    })
    return false;
}
