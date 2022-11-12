"use strict";(self.webpackChunkwebsite=self.webpackChunkwebsite||[]).push([[713],{3905:(e,t,r)=>{r.d(t,{Zo:()=>u,kt:()=>f});var n=r(7294);function o(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function a(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function i(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?a(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):a(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function l(e,t){if(null==e)return{};var r,n,o=function(e,t){if(null==e)return{};var r,n,o={},a=Object.keys(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||(o[r]=e[r]);return o}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(o[r]=e[r])}return o}var p=n.createContext({}),s=function(e){var t=n.useContext(p),r=t;return e&&(r="function"==typeof e?e(t):i(i({},t),e)),r},u=function(e){var t=s(e.components);return n.createElement(p.Provider,{value:t},e.children)},c={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},d=n.forwardRef((function(e,t){var r=e.components,o=e.mdxType,a=e.originalType,p=e.parentName,u=l(e,["components","mdxType","originalType","parentName"]),d=s(r),f=o,m=d["".concat(p,".").concat(f)]||d[f]||c[f]||a;return r?n.createElement(m,i(i({ref:t},u),{},{components:r})):n.createElement(m,i({ref:t},u))}));function f(e,t){var r=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var a=r.length,i=new Array(a);i[0]=d;var l={};for(var p in t)hasOwnProperty.call(t,p)&&(l[p]=t[p]);l.originalType=e,l.mdxType="string"==typeof e?e:o,i[1]=l;for(var s=2;s<a;s++)i[s]=r[s];return n.createElement.apply(null,i)}return n.createElement.apply(null,r)}d.displayName="MDXCreateElement"},9065:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>p,contentTitle:()=>i,default:()=>c,frontMatter:()=>a,metadata:()=>l,toc:()=>s});var n=r(7462),o=(r(7294),r(3905));const a={sidebar_position:9},i="Float",l={unversionedId:"supported-types/float",id:"supported-types/float",title:"Float",description:"The float provider generates a random float value between two doubles.",source:"@site/docs/supported-types/float.md",sourceDirName:"supported-types",slug:"/supported-types/float",permalink:"/model-forge/docs/supported-types/float",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/supported-types/float.md",tags:[],version:"current",sidebarPosition:9,frontMatter:{sidebar_position:9},sidebar:"tutorialSidebar",previous:{title:"File",permalink:"/model-forge/docs/supported-types/file"},next:{title:"Int",permalink:"/model-forge/docs/supported-types/int"}},p={},s=[{value:"Default Behavoir",id:"default-behavoir",level:3},{value:"Extending the Provider",id:"extending-the-provider",level:3}],u={toc:s};function c(e){let{components:t,...r}=e;return(0,o.kt)("wrapper",(0,n.Z)({},u,r,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("h1",{id:"float"},"Float"),(0,o.kt)("p",null,"The ",(0,o.kt)("inlineCode",{parentName:"p"},"float")," provider generates a random float value between two doubles."),(0,o.kt)("h3",{id:"default-behavoir"},"Default Behavoir"),(0,o.kt)("p",null,"Between ",(0,o.kt)("inlineCode",{parentName:"p"},"1.4E-45F")," and ",(0,o.kt)("inlineCode",{parentName:"p"},"3.4028235E38F")),(0,o.kt)("h3",{id:"extending-the-provider"},"Extending the Provider"),(0,o.kt)("p",null,"If you need a specific range you can pass custom ",(0,o.kt)("inlineCode",{parentName:"p"},"min")," and ",(0,o.kt)("inlineCode",{parentName:"p"},"max")," values to the provider:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-kotlin"},"    val float = FloatProvider(min = 1.0, max = 15.0).get()\n")))}c.isMDXComponent=!0}}]);