
var part = jQuery.parseJSON

var minHeight = 0;
$(document).ready(function()
{
    $('#bracket2').bracket(
	{

		teams: 6,
		topOffset:50,
		scale:0.45,
		horizontal:0,
		height:'1000px',
		icons:true,
		teamNames:
		[
		   {name: 'peta', seed: '6'}
		]
	});
}); 

function setMainTitleHeight()
{
	var windowHeight = $(window).height();
	if (windowHeight > minHeight)
	{
		$('#main-title').height(windowHeight);
		$('#main-title-content').css({'margin-top':(($('#main-title').height() - $('#main-title-content').height()) / 2) + 'px'
		});
	}
	else $('#main-title').height(minHeight);
}
