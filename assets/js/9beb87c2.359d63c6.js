"use strict";(self.webpackChunkwebsite=self.webpackChunkwebsite||[]).push([[80],{3905:(e,t,l)=>{l.d(t,{Zo:()=>d,kt:()=>c});var r=l(7294);function n(e,t,l){return t in e?Object.defineProperty(e,t,{value:l,enumerable:!0,configurable:!0,writable:!0}):e[t]=l,e}function a(e,t){var l=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),l.push.apply(l,r)}return l}function i(e){for(var t=1;t<arguments.length;t++){var l=null!=arguments[t]?arguments[t]:{};t%2?a(Object(l),!0).forEach((function(t){n(e,t,l[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(l)):a(Object(l)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(l,t))}))}return e}function u(e,t){if(null==e)return{};var l,r,n=function(e,t){if(null==e)return{};var l,r,n={},a=Object.keys(e);for(r=0;r<a.length;r++)l=a[r],t.indexOf(l)>=0||(n[l]=e[l]);return n}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(r=0;r<a.length;r++)l=a[r],t.indexOf(l)>=0||Object.prototype.propertyIsEnumerable.call(e,l)&&(n[l]=e[l])}return n}var o=r.createContext({}),p=function(e){var t=r.useContext(o),l=t;return e&&(l="function"==typeof e?e(t):i(i({},t),e)),l},d=function(e){var t=p(e.components);return r.createElement(o.Provider,{value:t},e.children)},m={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},s=r.forwardRef((function(e,t){var l=e.components,n=e.mdxType,a=e.originalType,o=e.parentName,d=u(e,["components","mdxType","originalType","parentName"]),s=p(l),c=n,h=s["".concat(o,".").concat(c)]||s[c]||m[c]||a;return l?r.createElement(h,i(i({ref:t},d),{},{components:l})):r.createElement(h,i({ref:t},d))}));function c(e,t){var l=arguments,n=t&&t.mdxType;if("string"==typeof e||n){var a=l.length,i=new Array(a);i[0]=s;var u={};for(var o in t)hasOwnProperty.call(t,o)&&(u[o]=t[o]);u.originalType=e,u.mdxType="string"==typeof e?e:n,i[1]=u;for(var p=2;p<a;p++)i[p]=l[p];return r.createElement.apply(null,i)}return r.createElement.apply(null,l)}s.displayName="MDXCreateElement"},1016:(e,t,l)=>{l.r(t),l.d(t,{assets:()=>o,contentTitle:()=>i,default:()=>m,frontMatter:()=>a,metadata:()=>u,toc:()=>p});var r=l(7462),n=(l(7294),l(3905));const a={sidebar_position:4},i="Changelog",u={unversionedId:"changelog",id:"changelog",title:"Changelog",description:"[1.3.0] - February 2nd 2023",source:"@site/docs/changelog.md",sourceDirName:".",slug:"/changelog",permalink:"/model-forge/docs/changelog",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/changelog.md",tags:[],version:"current",sidebarPosition:4,frontMatter:{sidebar_position:4},sidebar:"tutorialSidebar",previous:{title:"UUID",permalink:"/model-forge/docs/supported-types/uuid"},next:{title:"Migration Guide",permalink:"/model-forge/docs/migration"}},o={},p=[{value:"1.3.0 - February 2nd 2023",id:"130---february-2nd-2023",level:2},{value:"1.2.0 - November 12th 2022",id:"120---november-12th-2022",level:2},{value:"1.1.0 - October 5th 2022",id:"110---october-5th-2022",level:2},{value:"1.0.0 - July 25th 2022",id:"100---july-25th-2022",level:2},{value:"0.9.0 - March 22nd 2022",id:"090---march-22nd-2022",level:2},{value:"0.8.0 - December 7th 2021",id:"080---december-7th-2021",level:2},{value:"0.7.4 - September 16th 2021",id:"074---september-16th-2021",level:2},{value:"0.7.3 - September 15th 2021",id:"073---september-15th-2021",level:2},{value:"0.7.2 - July 29th 2021",id:"072---july-29th-2021",level:2},{value:"0.7.1 - June 26th 2021",id:"071---june-26th-2021",level:2},{value:"0.7.0 - June 7th 2021",id:"070---june-7th-2021",level:2},{value:"0.6.0 - June 3rd 2021",id:"060---june-3rd-2021",level:2},{value:"0.5.1 - June 1st 2021",id:"051---june-1st-2021",level:2},{value:"0.5.0 - May 30th 2021",id:"050---may-30th-2021",level:2},{value:"0.4.0 - May 26th 2021",id:"040---may-26th-2021",level:2},{value:"0.3.0 - May 13th 2021",id:"030---may-13th-2021",level:2},{value:"0.2.0 - May 6th 2021",id:"020---may-6th-2021",level:2},{value:"0.1.1 - April 30th 2021",id:"011---april-30th-2021",level:2},{value:"0.1.0 - April 28th 2021",id:"010---april-28th-2021",level:2}],d={toc:p};function m(e){let{components:t,...l}=e;return(0,n.kt)("wrapper",(0,r.Z)({},d,l,{components:t,mdxType:"MDXLayout"}),(0,n.kt)("h1",{id:"changelog"},"Changelog"),(0,n.kt)("h2",{id:"130---february-2nd-2023"},"[1.3.0]"," - February 2nd 2023"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Support Kotlin version 1.8.0"),(0,n.kt)("li",{parentName:"ul"},"Dependency updates")),(0,n.kt)("h2",{id:"120---november-12th-2022"},"[1.2.0]"," - November 12th 2022"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Add missing tests for sets"),(0,n.kt)("li",{parentName:"ul"},"Added asserts for types in tests"),(0,n.kt)("li",{parentName:"ul"},"Docusaurus website"),(0,n.kt)("li",{parentName:"ul"},"Workflow dependency updates")),(0,n.kt)("h2",{id:"110---october-5th-2022"},"[1.1.0]"," - October 5th 2022"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Dependency updates"),(0,n.kt)("li",{parentName:"ul"},"Housekeeping and general clean up")),(0,n.kt)("h2",{id:"100---july-25th-2022"},"[1.0.0]"," - July 25th 2022"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Auto publishing via CI"),(0,n.kt)("li",{parentName:"ul"},"Auto labeling via CI"),(0,n.kt)("li",{parentName:"ul"},"Removed deprecated reified functions"),(0,n.kt)("li",{parentName:"ul"},"Added missing test for custom char provider"),(0,n.kt)("li",{parentName:"ul"},"Added code of conduct"),(0,n.kt)("li",{parentName:"ul"},"Minor housekeeping tasks"),(0,n.kt)("li",{parentName:"ul"},"Dependency updates")),(0,n.kt)("h2",{id:"090---march-22nd-2022"},"[0.9.0]"," - March 22nd 2022"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Support for map collection type."),(0,n.kt)("li",{parentName:"ul"},"Better output message when using ",(0,n.kt)("inlineCode",{parentName:"li"},"attempt"),"."),(0,n.kt)("li",{parentName:"ul"},"Removed the custom Provider interface in favor of ",(0,n.kt)("inlineCode",{parentName:"li"},"javax.inject.Provider"),".",(0,n.kt)("ul",{parentName:"li"},(0,n.kt)("li",{parentName:"ul"},"See ",(0,n.kt)("a",{parentName:"li",href:"/model-forge/docs/migration"},"Migration Guide")," for details."))),(0,n.kt)("li",{parentName:"ul"},"Moved dependency definitions to ",(0,n.kt)("inlineCode",{parentName:"li"},"buildSrc")),(0,n.kt)("li",{parentName:"ul"},"Fixed StringProvider to be more explicit when generating strings.")),(0,n.kt)("h2",{id:"080---december-7th-2021"},"[0.8.0]"," - December 7th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Auto generation for additional types:",(0,n.kt)("ul",{parentName:"li"},(0,n.kt)("li",{parentName:"ul"},"Byte"),(0,n.kt)("li",{parentName:"ul"},"Char"),(0,n.kt)("li",{parentName:"ul"},"Short"),(0,n.kt)("li",{parentName:"ul"},"UUID"))),(0,n.kt)("li",{parentName:"ul"},"Support for Set collection type"),(0,n.kt)("li",{parentName:"ul"},"Dependency updates")),(0,n.kt)("h2",{id:"074---september-16th-2021"},"[0.7.4]"," - September 16th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Build with Java 8")),(0,n.kt)("h2",{id:"073---september-15th-2021"},"[0.7.3]"," - September 15th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Add GitHub Action dependencies to dependabot"),(0,n.kt)("li",{parentName:"ul"},"Dependency updates")),(0,n.kt)("h2",{id:"072---july-29th-2021"},"[0.7.2]"," - July 29th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Allow for forging Enums directly through ModelForge.build"),(0,n.kt)("li",{parentName:"ul"},"Add more Kotlin Provider<T",">"," fanciness")),(0,n.kt)("h2",{id:"071---june-26th-2021"},"[0.7.1]"," - June 26th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Don't instantiate reflective objects when handling custom providers")),(0,n.kt)("h2",{id:"070---june-7th-2021"},"[0.7.0]"," - June 7th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Added reified inline extension functions")),(0,n.kt)("h2",{id:"060---june-3rd-2021"},"[0.6.0]"," - June 3rd 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Exclude Companion Object Values"),(0,n.kt)("li",{parentName:"ul"},"Support for File type.")),(0,n.kt)("h2",{id:"051---june-1st-2021"},"[0.5.1]"," - June 1st 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Support for optional variables.")),(0,n.kt)("h2",{id:"050---may-30th-2021"},"[0.5.0]"," - May 30th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Support for List collection type."),(0,n.kt)("li",{parentName:"ul"},"Support for complex data types."),(0,n.kt)("li",{parentName:"ul"},"Support for custom providers.")),(0,n.kt)("h2",{id:"040---may-26th-2021"},"[0.4.0]"," - May 26th 2021"),(0,n.kt)("p",null,"Auto generation for enums."),(0,n.kt)("h2",{id:"030---may-13th-2021"},"[0.3.0]"," - May 13th 2021"),(0,n.kt)("p",null,"Auto generation for additional types:"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Calendar"),(0,n.kt)("li",{parentName:"ul"},"Instant")),(0,n.kt)("h2",{id:"020---may-6th-2021"},"[0.2.0]"," - May 6th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Allow using Kotlin class definitions directly."),(0,n.kt)("li",{parentName:"ul"},"Added forgery and forgeries property delegate.")),(0,n.kt)("h2",{id:"011---april-30th-2021"},"[0.1.1]"," - April 30th 2021"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Java 8 compatibility")),(0,n.kt)("h2",{id:"010---april-28th-2021"},"[0.1.0]"," - April 28th 2021"),(0,n.kt)("p",null,"The initial release supports auto generated models for the following types:"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Boolean"),(0,n.kt)("li",{parentName:"ul"},"Date"),(0,n.kt)("li",{parentName:"ul"},"Double"),(0,n.kt)("li",{parentName:"ul"},"Float"),(0,n.kt)("li",{parentName:"ul"},"Int"),(0,n.kt)("li",{parentName:"ul"},"Long"),(0,n.kt)("li",{parentName:"ul"},"String")))}m.isMDXComponent=!0}}]);