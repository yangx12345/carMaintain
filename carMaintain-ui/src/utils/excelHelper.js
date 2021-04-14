import enumObj from '@/utils/enum.js'
let XLSX = require("xlsx");
let FileSaver = require("file-saver")

export function exportExcel({excelTitle,titleField,exportData,fileName,auxData}){
    var arry = [
        excelTitle,
    ];
    if(!titleField){
        titleField = [];
        for(let key in exportData[0]){
            titleField.push(key);
        }
    }
    exportData.map(a => {
        var _arry = [];
        for (let _i in a) {
            let arrIndex = titleField.indexOf(_i)
            if (arrIndex != -1) {
                if (a[_i] != null) {
                    if (auxData && auxData[arrIndex].config) {
                        if ((auxData[arrIndex].config.type == "button" || auxData[arrIndex].config.type == "select") && !auxData[arrIndex].config.requestKey) {
                            try {
                                _arry[arrIndex] = enumObj.Enum.enumType[auxData[arrIndex].config.enumType][a[_i]];
                            } catch (e) {
                                _arry[arrIndex] = [a[_i]];
                                console.warn("匹配不到 " + _i + "类型的值 [" + a[_i] + "] 的枚举，已自动取消枚举转换!!!");
                            }
                        } else {
                            _arry[arrIndex] = a[_i];
                        }
                    } else {                   
                        _arry[arrIndex] = a[_i]                  
                    }
                } else {
                    console.log("字段" + _arry[arrIndex] + "不存在", "索引为", arrIndex, _i)
                    _arry[arrIndex] = "";
                }
            }
        }
        return _arry;
    }).forEach(a => {
        arry.push(a);
    });
    var sheetHistory = XLSX.utils.aoa_to_sheet(arry);
    sheetHistory["A1"].s = { font: { sz: 14, bold: true, color: { rgb: "#FFFF00" } }, fill: { bgColor: { indexed: 64 }, fgColor: { rgb: "#FFaF00" } } };//<====设置xlsx单元格样式
    var workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, sheetHistory, fileName);
    try {
        var wbOut = XLSX.write(workbook, {
            bookType: "xlsx",
            bookSST: false,
            cellStyles: true,
            type: "array"
        });
        FileSaver.saveAs(
            new Blob([wbOut], {
                type: "application/octet-stream"
            }),
            fileName + ".xlsx"
        );
    } catch (e) {
        console.log(e, wbOut);
    }
}