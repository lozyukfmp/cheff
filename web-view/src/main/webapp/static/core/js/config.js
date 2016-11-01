requirejs.config({
    paths: {
        'jquery': "lib/jquery-3.1.1",
        'bootstrap': "lib/bootstrap",
        'app': "app",
        'details': "modules/details",
        'ajax': 'modules/ajax'
    }
});

require(['app'], function (app) {
    app.init();
});
