angular
    .module('ps.config.restangular', ['restangular'])
    .config((RestangularProvider) => {
        RestangularProvider.setBaseUrl('/api/');
        RestangularProvider.addElementTransformer('items', false, (item) => {
            item.addRestangularMethod('reset', 'get', 'reset');
            item.addRestangularMethod('download', 'get', 'addtoqueue');
            return item;
        });
    });