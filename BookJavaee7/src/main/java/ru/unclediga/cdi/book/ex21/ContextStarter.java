package ru.unclediga.cdi.book.ex21;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.Map;
import java.util.HashMap;

import org.jboss.weld.context.bound.BoundConversationContext;
import org.jboss.weld.context.bound.MutableBoundRequest;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;

//import org.jboss.weld.environment.se.contexts.activators.ActivateThreadScope;

//@ActivateThreadScope
public class ContextStarter implements Serializable{

  Map<String, Object> reqDS = new HashMap<>();
  Map<String, Object> sessDS = new HashMap<>();

  @Inject
  CustomerServiceWizard wizard;

  @Inject BoundConversationContext conversationContext;


    public void testCtx(){    
      System.out.println("conversationContext = " + conversationContext);
      startTransientConversation(reqDS, sessDS);
      wizard.saveLogin();
      wizard.testLogger();
      endOrPassivateConversation(reqDS,sessDS);

    }  



    public void testLogger(){    
      wizard.testLogger();
    }  

    public void saveLogin(){
        wizard.saveLogin();
    }

    public void saveAccount(){
        wizard.saveAccount();
    }

    public void createCustomer(){
      wizard.createCustomer();
    }





   /* Start a transient conversation */
   /* Provide a data store which will last the lifetime of the request */
   /* and one that will last the lifetime of the session */
   public void startTransientConversation(Map<String, Object> requestDataStore,
                                          Map<String, Object> sessionDataStore) {
      resumeOrStartConversation(requestDataStore, sessionDataStore, null);
   }

   /* Start a transient conversation (if cid is null) or resume a non-transient */
   /* conversation. Provide a data store which will last the lifetime of the request */
   /* and one that will last the lifetime of the session */
   public void resumeOrStartConversation(Map<String, Object> requestDataStore,
                                         Map<String, Object> sessionDataStore,
                                         String cid) {
      /* Associate the stores with the context and activate the context */
      /* BoundRequest just wraps the two datastores */
      conversationContext.associate(new MutableBoundRequest(requestDataStore, sessionDataStore));
      // Pass the cid in
      conversationContext.activate(cid);
   }

   /* End the conversations, providing the same data store as was used to start */
   /* the request. Any transient conversations will be destroyed, any newly-promoted */
   /* conversations will be placed into the session */
   public void endOrPassivateConversation(Map<String, Object> requestDataStore,
                                          Map<String, Object> sessionDataStore) {
      try {
         /* Invalidate the conversation (all transient conversations will be scheduled for destruction) */
         conversationContext.invalidate();
         /* Deactivate the conversation, causing all transient conversations to be destroyed */
         conversationContext.deactivate();
      } finally {
        /* Ensure that whatever happens we dissociate to prevent memory leaks*/
         conversationContext.dissociate(new MutableBoundRequest(requestDataStore, sessionDataStore));
      }
   }

}  
