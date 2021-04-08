if (window.addEventListener) {
        /* Modern  browsers for all other browser*/
        window.addEventListener("load", onLoad, false)
    }
    else if (window.attachEvent) {
        /* IE    for internet explorer */
        window.detachEvent("onload", onLoad)
        window.attachEvent("onload", onLoad)
    }
    else {
        window.onload = onLoad
    }


function onLoad() {
//      alert("I am running bbbbbbbbbbbbbbbbbbb!");
//     var panelTabbed =   AdfPage.PAGE.findComponent("pt1");
//        panelTabbed.setProperty("inlineStyle","height:100px");
//        panelTabbed.setProperty("inlineStyle", "background-color:red");

   
}

 function onDocumentLoad() {
       
//        var screenHeight = screen.height;
        // this height hasbeen adjusted to see in oaf 
//        var  height = screenHeight-0;
//         var panelsplitter =   AdfPage.PAGE.findComponent("ps1");
//        panelsplitter.setProperty("inlineStyle","height:"+height+'px');
          
//       panel.setProperty("inlineStyle", "background-color:"+color);
//       var color = "green";
//        panelTabbed.setProperty("inlineStyle","10px");
//         panelTabbed.setProperty("inlineStyle", "background-color:"+color);
//
//       var panelSplitter = AdfPage.PAGE.findComponent("ps1");
//       panelSplitter.setProperty("inlineStyle","height:"+screenHeight+'px');
//        panelSplitter.setProperty("inlineStyle", "background-color:"+color);
        
//         var panelStretcher =     AdfPage.PAGE.findComponent("ps1");   
//         panelStretcher.setProperty("inlineStyle","height:"+height+'px');
        
        
        
        
}
    