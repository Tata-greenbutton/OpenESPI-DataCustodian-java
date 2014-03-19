package org.energyos.espi.datacustodian.web.customer;

import org.springframework.security.core.Authentication;
import org.energyos.espi.common.domain.Authorization;
import org.energyos.espi.common.domain.Routes;
import org.energyos.espi.common.service.AuthorizationService;
import org.energyos.espi.datacustodian.utils.URLHelper;
import org.energyos.espi.datacustodian.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.energyos.espi.common.domain.RetailCustomer;


@Controller
@RequestMapping(Routes.AUTHORIZED_THIRD_PARTIES)
public class AuthorizedThirdPartiesController extends BaseController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model, Authentication principal) {
	//RetailCustomer currentCustomer = currentCustomer(principal);
        model.put("authorizationList", authorizationService.findAllByRetailCustomerId(currentCustomer(principal).getId()));
        return "/customer/authorizedThirdParties/index";
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public String selectThirdParty(@RequestParam("Third_party") Long thirdPartyId, @RequestParam("Third_party_URL") String thirdPartyURL) {
        /*ApplicationInformation applicationInformation = applicationInformationService.findById(thirdPartyId);
        return "redirect:" + thirdPartyURL + "?" + URLHelper.newScopeParams(applicationInformation.getScope()) 
        		+ "&DataCustodianID=" + applicationInformation.getDataCustodianId();
    }*/

    /*public void setApplicationInformationService(ApplicationInformationService applicationInformationService) {
        /*this.applicationInformationService = applicationInformationService;
    }*/
}
