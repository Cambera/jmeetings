package jmeetings

class SecurityFilters {
	//FIXME usar um mapa de controllerName:actionName[] permitidos
    def filters = {
        loginCheck(controller:'*', action:'*') {
            before = {
                if(
					(!
						((controllerName == 'inscricao' &&
							(actionName == 'create' || actionName == 'save' || actionName == 'confirmar'))
						||						
						(controllerName == 'palestra' && 
							(actionName == 'create' || actionName == 'save' || actionName == 'show'))) && !session.user) 
						
						&& controllerName != 'login'){
                    redirect(controller:'login')
                }
            }

        }
    }
}