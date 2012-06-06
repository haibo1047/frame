var leftArray = new Array();
var rightArray = new Array();
var lastLeftArray = new Array();
var currentLeftArray = new Array();
function init(leftSelectId, rightSelectId) {
	var leftSelect = document.getElementById(leftSelectId);
	var rightSelect = document.getElementById(rightSelectId);
	for ( var i = 0; i < leftSelect.length; i++) {
		leftArray[i] = new Array();
		leftArray[i].text = leftSelect.options[i].text;
		leftArray[i].value = leftSelect.options[i].value;
	}
	for ( var i = 0; i < rightSelect.length; i++) {
		rightArray[i] = new Array();
		rightArray[i].text = rightSelect.options[i].text;
		rightArray[i].value = rightSelect.options[i].value;
	}
	lastLeftArray = copyArray(leftArray);
}
function destroy() {
	leftArray.length = 0;
	rightArray.length = 0;
	lastLeftArray.length = 0;
	currentLeftArray.length = 0;
}

function leftToRight(leftDel) {
	var temp = new Array();
	for ( var i = 0; i < leftArray.length; i++) {
		var flag = 0;
		for ( var j = 0; j < leftDel.length; j++) {
			if (leftArray[i].value == leftDel[j].value) {
				rightArray.push(leftArray[i]);
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			temp.push(leftArray[i]);
		}
	}
	leftArray = copyArray(temp);
	selectOptions = copyArray(leftArray);
	lastLeftArray = copyArray(leftArray);
}

function copyArray(source) {
	var target = new Array();
	for ( var i = 0; i < source.length; i++) {
		var kk = target.length;
		target[kk] = new Array();
		target[kk].value = source[i].value;
		target[kk].text = source[i].text;
	}
	return target;
}

function rightToLeft(rightDel) {
	var temp = new Array();
	for ( var i = 0; i < rightArray.length; i++) {
		var flag = 0;
		for ( var j = 0; j < rightDel.length; j++) {
			if (rightArray[i].value == rightDel[j].value) {
				flag = 1;
				leftArray.push(rightArray[i]);
				break;
			}
		}
		if (flag == 0) {
			temp.push(rightArray[i]);
		}
	}
	rightArray = temp;
	selectOptions = copyArray(leftArray);
	lastLeftArray = copyArray(leftArray);
}

function moveIt(oSource, oTarget, direct) {
	if (!oSource.options.length) {
		return;
	}
	if (oSource.selectedIndex == -1) {
		selectMoveAll(oSource, oTarget);
		destroy();
		init('unSelectedElement', 'selectedElement');
		return;
	}
	var mySld = new Array();
	var del = new Array();
	for (i = 0; i < oSource.options.length; i++) {
		if (oSource.options[i].selected) {
			mySld[mySld.length] = i;
			var kk = del.length;
			del[kk] = new Array();
			del[kk].value = oSource.options[i].value;
			del[kk].text = oSource.options[i].text;
			var len = oTarget.options.length;
			oTarget.options[len] = new Option();
			oTarget.options[len].text = del[kk].text;
			oTarget.options[len].value = del[kk].value;
		}
	}
	var tar = new Array();
	var dd = "," + mySld.join(",") + ",";
	for (j = 0; j < oSource.options.length; j++) {
		if (dd.indexOf("," + j + ",") == -1) {
			tar[tar.length] = new Option(oSource.options[j].text,
					oSource.options[j].value);
		}
	}

	oSource.options.length = 0;
	for (x = 0; x < tar.length; x++) {
		oSource.options.add(tar[x]);
	}
	if (oSource.options.length >= 1) {
		oSource.options.selectedIndex = -1;
	}
	if (direct == 1) {
		leftToRight(del);
	} else if (direct == 2) {
		rightToLeft(del);
	}
}
var flag = false;
function doMyFilter(input, select_obj, formType) {
	var input_value = "";
	var doFilterLeftArray;
	if (formType == 1) {
		input_value = input.options[input.selectedIndex].text;
		doFilterLeftArray = copyArray(lastLeftArray);
		flag = true;
	} else if (formType == 2) {
		input_value = input;
		if (flag) {
			doFilterLeftArray = copyArray(currentLeftArray);
			flag = false;
		} else {
			doFilterLeftArray = copyArray(lastLeftArray);
		}

	}

	if (input_value == "") {
		select_obj.options.length = 0;
		if (formType == 1) {
			currentLeftArray = copyArray(lastLeftArray);
		}
		for ( var i = 0; i < lastLeftArray.length; i++) {
			var option = new Option(lastLeftArray[i].text,
					lastLeftArray[i].value);
			select_obj.options[i] = option;
		}

	} else {
		var keystr = input_value;
		var new_selectOptions = new Array();

		for ( var i = 0; i < doFilterLeftArray.length; i++) {
			if (doFilterLeftArray[i].text.indexOf(keystr) != -1) {
				new_selectOptions[new_selectOptions.length] = doFilterLeftArray[i];
			}
		}
		if (formType == 1) {
			currentLeftArray = copyArray(new_selectOptions);
		}
		if (select_obj.options != new_selectOptions) {
			select_obj.options.length = 0;
			for ( var i = 0; i < new_selectOptions.length; i++) {
				var option = new Option(new_selectOptions[i].text,
						new_selectOptions[i].value);
				select_obj.options[i] = option;
			}
		}
	}
}
