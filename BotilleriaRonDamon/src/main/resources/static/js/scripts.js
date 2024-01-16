
let combo;
let ruta;
let imagen;
let modificar;
let eliminar;
let controlesCheckbox;
let checkboxPrincipal;
let cantidad;
let formulario;
let formularioEditar;
let oculto;
let idCapturado;
let volver;
let idVarios;
let idProductos = [];
let comienzo;
let vaciar;

let principal = () => {
	cantidad = 0;
	idVarios = '';
	combo = $('#selProducto');
	imagen = $('#imgProducto');
	formulario = $('#frmCrud');
	modificar = $('#btnModificar');
	eliminar = $('#btnEliminar');
	controlesCheckbox = $('.items');
	checkboxPrincipal = $('#todos');
	oculto = $('#ids');
	combo.change(mostrar);
	volver = $('#btnVolver');
	formularioEditar = $('#frmEditar');
	modificar.attr('disabled', true);
	eliminar.attr('disabled', true);
	modificar.attr('type', 'button');
	eliminar.attr('type', 'button');
	volver.attr('type', 'button');
	comienzo = true;
	vaciar = $('#btnVaciar');

	$('#automatico').click(() => {

		if (confirm('Realmente desea agregar productos automaticamente?')) {

			$('#automatico').hide();

			$('#automatico').prop('href', '/products/automatic_products');
		}
		else
			$('#automatico').prop('href', '/products/read_all');

	});

	$(checkboxPrincipal).change(estadoCajaPrincipal);
	$(controlesCheckbox).change(checkeados);
	$(modificar).click(modificando);
	$(volver).click(volviendo);
	$(eliminar).click(eliminando);
	$(vaciar).click(vaciando);

	$(".items:checked").each(function() {
		idVarios.push(this.value);
	});
	$(oculto).val(idVarios);
		
	mostrar;
}

let volviendo = () => {
	
	window.location.href = '/products/read_all';
}

let modificando = () => {

	cantidad = $('.items:checked').length;

	if (cantidad == 1) {
		$(oculto).val($('.items:checked').prop('id'));
		$(modificar).prop('type', 'submit');
		$(formulario).prop('action', '/products/edit');
	} else
		alert('Debe modificar un producto a la vez');
}

let eliminando = () => {

	let cantidad = $('.items:checked').length;
	let totalCheckbox = $('.items:checkbox').length;
	let ids = '';
	idProductos = null;
	let temporal;

	$('.items:checked').each((indice) => {

		temporal = $('.items:checked').get(indice);

		ids += ($(temporal).prop('id') + ',');
	});

	temporal = ids.substr(0, ids.length - 1) + '.';


	if (confirm((cantidad == 1) ? 'Realmente desea eliminar el producto ' + $('.items:checked').prop('id')
		+ '?' : (cantidad != totalCheckbox) ? 'Realmente desea eliminar estos ' + cantidad + ' productos?\n' + temporal : 'Realmente desea eliminar todos los productos?')) {
		$(eliminar).prop('type', 'submit');
		$(oculto).val(ids);
		$(formulario).attr('action', '/products/remove');
	}
	else
		window.location.href = '/products/read_all';
}

let estadoCajaPrincipal = () => {

	controlesCheckbox.prop('checked', $(checkboxPrincipal).prop('checked'));

	if ($(checkboxPrincipal).prop('checked')) {
		modificar.attr('disabled', false);
		eliminar.attr('disabled', false);
	}
	else {
		modificar.attr('disabled', true);
		eliminar.attr('disabled', true);
	}

	//$(oculto).val($('.items:checked').prop('id'));
}

let concateno = () => {
	let sel = $('.items:checked').prop('id');

	for (let s in sel) {

		idVarios += ($(s).attr('id') + ',');
	}

	$(oculto).val(idVarios);
}

let checkeados = () => {

	let seleccionados = $('.items:checked');

	let temporal = $(seleccionados).length;

	let total = $('.items').length;

	let temp;

	if (temporal == total | temporal > 0 & temporal <= total) {

		modificar.attr('disabled', false);
		eliminar.attr('disabled', false);

		if (temporal == total)
			$(checkboxPrincipal).prop('checked', true);
		else
			$(checkboxPrincipal).prop('checked', false);

	}
	else {

		modificar.attr('disabled', true);
		eliminar.attr('disabled', true);
	}
}

let mostrar = () => {

	let seleccionado = $('#selProducto option:selected');

	if ($(seleccionado).text() == 'seleccione bebestible') {
		ruta = "/img/tragos.png";
		alert('Debe elegir otra opcion');
	}
	else {
		ruta = "/img/" + $(seleccionado).text();
	}

	$(imagen).prop('src', ruta);	
}

let estadoBotones = () => {

	if (seleccionaTodos.is(':checked')) {

		apagar(true);
		modificar.attr('disabled', false);
		eliminar.attr('disabled', false);
	} else {
		apagar(false);
		modificar.attr('disabled', true);
		eliminar.attr('disabled', true);
	}
}

let vaciando = () => {
	
	$(imagen).prop('src', '/img/tragos.png');
}

$(document).ready(principal);
