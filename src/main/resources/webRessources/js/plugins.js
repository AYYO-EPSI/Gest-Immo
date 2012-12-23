// Avoid `console` errors in browsers that lack a console.
(function () {
	var method;
	var noop = function noop() {
	};
	var methods = [
		'assert', 'clear', 'count', 'debug', 'dir', 'dirxml', 'error',
		'exception', 'group', 'groupCollapsed', 'groupEnd', 'info', 'log',
		'markTimeline', 'profile', 'profileEnd', 'table', 'time', 'timeEnd',
		'timeStamp', 'trace', 'warn'
	];
	var length = methods.length;
	var console = (window.console = window.console || {});

	while (length--) {
		method = methods[length];

		if (!console[method]) {
			console[method] = noop;
		}
	}
}());

//AVOID FOUC
(function (H) {
	H.className = H.className.replace(/\bno-js\b/, 'js')
})(document.documentElement);