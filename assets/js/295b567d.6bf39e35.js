"use strict";(self.webpackChunkwebsite=self.webpackChunkwebsite||[]).push([[154],{3905:(e,t,r)=>{r.d(t,{Zo:()=>u,kt:()=>m});var n=r(7294);function a(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function i(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function o(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?i(Object(r),!0).forEach((function(t){a(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):i(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function l(e,t){if(null==e)return{};var r,n,a=function(e,t){if(null==e)return{};var r,n,a={},i=Object.keys(e);for(n=0;n<i.length;n++)r=i[n],t.indexOf(r)>=0||(a[r]=e[r]);return a}(e,t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);for(n=0;n<i.length;n++)r=i[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(a[r]=e[r])}return a}var c=n.createContext({}),p=function(e){var t=n.useContext(c),r=t;return e&&(r="function"==typeof e?e(t):o(o({},t),e)),r},u=function(e){var t=p(e.components);return n.createElement(c.Provider,{value:t},e.children)},s={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},d=n.forwardRef((function(e,t){var r=e.components,a=e.mdxType,i=e.originalType,c=e.parentName,u=l(e,["components","mdxType","originalType","parentName"]),d=p(r),m=a,f=d["".concat(c,".").concat(m)]||d[m]||s[m]||i;return r?n.createElement(f,o(o({ref:t},u),{},{components:r})):n.createElement(f,o({ref:t},u))}));function m(e,t){var r=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var i=r.length,o=new Array(i);o[0]=d;var l={};for(var c in t)hasOwnProperty.call(t,c)&&(l[c]=t[c]);l.originalType=e,l.mdxType="string"==typeof e?e:a,o[1]=l;for(var p=2;p<i;p++)o[p]=r[p];return n.createElement.apply(null,o)}return n.createElement.apply(null,r)}d.displayName="MDXCreateElement"},3500:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>c,contentTitle:()=>o,default:()=>s,frontMatter:()=>i,metadata:()=>l,toc:()=>p});var n=r(7462),a=(r(7294),r(3905));const i={sidebar_position:5},o="Migration Guide",l={unversionedId:"migration",id:"migration",title:"Migration Guide",description:"1.0.0 - July 25th 2022",source:"@site/docs/migration.md",sourceDirName:".",slug:"/migration",permalink:"/model-forge/docs/migration",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/migration.md",tags:[],version:"current",sidebarPosition:5,frontMatter:{sidebar_position:5},sidebar:"tutorialSidebar",previous:{title:"Changelog",permalink:"/model-forge/docs/changelog"}},c={},p=[{value:"1.0.0 - July 25th 2022",id:"100---july-25th-2022",level:2},{value:"0.9.0 - March 22nd 2022",id:"090---march-22nd-2022",level:2}],u={toc:p};function s(e){let{components:t,...r}=e;return(0,a.kt)("wrapper",(0,n.Z)({},u,r,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("h1",{id:"migration-guide"},"Migration Guide"),(0,a.kt)("h2",{id:"100---july-25th-2022"},"1.0.0 - July 25th 2022"),(0,a.kt)("p",null,"In version 1.0.0 we removed the deprecated ",(0,a.kt)("inlineCode",{parentName:"p"},"forgeries")," and ",(0,a.kt)("inlineCode",{parentName:"p"},"build")," (list) reified functions. The same functionality\nis covered in the ",(0,a.kt)("inlineCode",{parentName:"p"},"forgeryList()")," and ",(0,a.kt)("inlineCode",{parentName:"p"},"buildList()")," functions."),(0,a.kt)("p",null,"Replace instances of:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin"},"forgeries()\n")),(0,a.kt)("p",null,"with:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin"},"forgeryList()\n")),(0,a.kt)("p",null,"Replace all instances of:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin"},"build() // list\n")),(0,a.kt)("p",null,"with:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin"},"buildList()\n")),(0,a.kt)("h2",{id:"090---march-22nd-2022"},"0.9.0 - March 22nd 2022"),(0,a.kt)("p",null,"In version 0.9.0 we removed the custom provider in favor of javax provider for easier\nadaptation in other projects. "),(0,a.kt)("p",null,"Replace all instances of:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin"},"    import io.github.hellocuriosity.providers.Provider\n")),(0,a.kt)("p",null,"with:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-kotlin"},"    import javax.inject.Provider\n")))}s.isMDXComponent=!0}}]);