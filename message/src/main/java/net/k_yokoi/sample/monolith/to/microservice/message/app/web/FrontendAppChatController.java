package net.k_yokoi.sample.monolith.to.microservice.message.app.web;

import java.util.ArrayList;
import net.k_yokoi.sample.monolith.to.microservice.message.app.model.chat.ChatPortalInformation;
import net.k_yokoi.sample.monolith.to.microservice.message.app.model.chat.GetMessagesResult;
import net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.chat.GetMessageResultMapper;
import net.k_yokoi.sample.monolith.to.microservice.message.app.web.security.CustomUserDetails;
import net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.exception.BusinessException;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.service.chat.ChatOrchestrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontendAppChatController {

    @Autowired
    ChatOrchestrationService chatOrchestrationService;

    @Autowired
    GetMessageResultMapper getMessageResultMapper;

    @GetMapping(value = "/chat")
    public String chatPortal(@AuthenticationPrincipal CustomUserDetails customUserDetails,
            Model model){
        model.addAttribute("userResource", customUserDetails.getUserResource());
        model.addAttribute("chatPortalInformation",
                ChatPortalInformation.builder().messageBoardResources(
                        chatOrchestrationService.getMessageBoardResources(
                                customUserDetails.getUserResource().getUserId())).build());
        return "chat";
    }

    @GetMapping(value = "/chat/messages")
    public ResponseEntity<GetMessagesResult> getMessages(
            @RequestParam String messageBoardId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    getMessageResultMapper.map(chatOrchestrationService
                            .getMessageResources(messageBoardId)));
        }catch (BusinessException e){
            // System.err.println(e);
            return ResponseEntity.status(HttpStatus.OK).body(
                    GetMessagesResult.builder().messageResources(
                            new ArrayList<>()).build());
        }
    }


}