/**
 * Created by CJ on 6/18/16.
 */
// 自动增强数据类型

$(function () {
    /////性别
    var sexList = [
        {
            name: '男',
            value: true
        }, {
            name: '女',
            value: false
        }
    ];
    var sexSelect = $('select[class~=sexSelect]');
    $.each(sexList, function (index, data) {
        sexSelect.append($('<option>', {value: data.value, text: data.name}));
    });
    ///民族
    var nationalityList = [
        '汉族', '蒙古族', '回族', '藏族', '维吾尔族', '苗族', '彝族', '壮族', '布依族', '朝鲜族', '满族', '侗族', '瑶族'
        , '白族', '土家族', '哈尼族', '哈萨克族', '傣族', '黎族', '僳僳族', '佤族', '畲族', '高山族', '拉祜族', '水族'
        , '东乡族', '纳西族', '景颇族', '柯尔克孜族', '土族', '达斡尔族', '仫佬族', '羌族', '布朗族', '撒拉族', '毛南族'
        , '仡佬族', '锡伯族', '阿昌族', '普米族', '塔吉克族', '怒族', '乌孜别克族', '俄罗斯族', '鄂温克族', '德昂族'
        , '保安族', '裕固族', '京族', '塔塔尔族', '独龙族', '鄂伦春族', '赫哲族', '门巴族', '珞巴族', '基诺族'
    ];
    var nationalitySelect = $('select[class~=nationalitySelect]');
    $.each(nationalityList, function (index, data) {
        nationalitySelect.append($('<option>', {value: data, text: data}));
    });

    nationalitySelect.chosen({'width': '100%', 'white-space': 'nowrap'});

    //户籍类型
    var censusTypeList = [
        {
            name: '农民',
            value: 0
        }, {
            name: '居民',
            value: 1
        }
    ];
    var censusTypeSelect = $('select[class~=censusTypeSelect]');
    $.each(censusTypeList, function (index, data) {
        censusTypeSelect.append($('<option>', {value: data.value, text: data.name}));
    });

    //户籍类型
    var cultureList = [
        {
            name: '博士',
            value: 7
        }, {
            name: '硕士',
            value: 6
        }, {
            name: '本科',
            value: 5
        }, {
            name: '专科',
            value: 4
        }, {
            name: '高中',
            value: 3
        }, {
            name: '初中',
            value: 2
        }, {
            name: '小学',
            value: 1
        }, {
            name: '文盲',
            value: 0
        }
    ];
    var cultureSelect = $('select[class~=cultureSelect]');
    $.each(cultureList, function (index, data) {
        cultureSelect.append($('<option>', {value: data.value, text: data.name}));
    });

    //婚姻状况
    var marriageList = [
        {
            name: '未婚',
            value: 0
        }, {
            name: '已婚',
            value: 1
        }, {
            name: '离异',
            value: 2
        }
    ];
    var marriageSelect = $('select[class~=marriageSelect]');
    $.each(marriageList, function (index, data) {
        marriageSelect.append($('<option>', {value: data.value, text: data.name}));
    });

    //日期
    $.datepicker.setDefaults($.datepicker.regional["zhCN"]);
    $('input[class~=datePicker]').datepicker({
        dateFormat: 'yy-mm-dd'
    });
});