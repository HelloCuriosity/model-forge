"use strict";(self.webpackChunkwebsite=self.webpackChunkwebsite||[]).push([[802],{5206:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>a,contentTitle:()=>i,default:()=>p,frontMatter:()=>o,metadata:()=>d,toc:()=>c});var r=n(4848),s=n(8453);const o={sidebar_position:16},i="UInt",d={id:"supported-types/uint",title:"UInt",description:"The UInt provider generates a random UInt value between two unsigned integers.",source:"@site/docs/supported-types/uint.md",sourceDirName:"supported-types",slug:"/supported-types/uint",permalink:"/model-forge/docs/supported-types/uint",draft:!1,unlisted:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/supported-types/uint.md",tags:[],version:"current",sidebarPosition:16,frontMatter:{sidebar_position:16},sidebar:"tutorialSidebar",previous:{title:"UByte",permalink:"/model-forge/docs/supported-types/ubyte"},next:{title:"ULong",permalink:"/model-forge/docs/supported-types/ulong"}},a={},c=[{value:"Default Behavior",id:"default-behavior",level:3},{value:"Extending the Provider",id:"extending-the-provider",level:3}];function u(e){const t={code:"code",h1:"h1",h3:"h3",header:"header",p:"p",pre:"pre",...(0,s.R)(),...e.components};return(0,r.jsxs)(r.Fragment,{children:[(0,r.jsx)(t.header,{children:(0,r.jsx)(t.h1,{id:"uint",children:"UInt"})}),"\n",(0,r.jsxs)(t.p,{children:["The ",(0,r.jsx)(t.code,{children:"UInt"})," provider generates a random UInt value between two unsigned integers."]}),"\n",(0,r.jsx)(t.h3,{id:"default-behavior",children:"Default Behavior"}),"\n",(0,r.jsxs)(t.p,{children:["Between ",(0,r.jsx)("code",{children:"0"})," and ",(0,r.jsxs)("code",{children:["4,294,967,295 (2",(0,r.jsx)("sup",{children:"32 - 1"}),")"]})]}),"\n",(0,r.jsx)(t.h3,{id:"extending-the-provider",children:"Extending the Provider"}),"\n",(0,r.jsxs)(t.p,{children:["If you need a specific range you can pass custom ",(0,r.jsx)(t.code,{children:"min"})," and ",(0,r.jsx)(t.code,{children:"max"})," values to the provider:"]}),"\n",(0,r.jsx)(t.pre,{children:(0,r.jsx)(t.code,{className:"language-kotlin",children:"    val uInteger = UIntProvider(min = 1u, max = 15u).get()\n"})})]})}function p(e={}){const{wrapper:t}={...(0,s.R)(),...e.components};return t?(0,r.jsx)(t,{...e,children:(0,r.jsx)(u,{...e})}):u(e)}},8453:(e,t,n)=>{n.d(t,{R:()=>i,x:()=>d});var r=n(6540);const s={},o=r.createContext(s);function i(e){const t=r.useContext(o);return r.useMemo((function(){return"function"==typeof e?e(t):{...t,...e}}),[t,e])}function d(e){let t;return t=e.disableParentContext?"function"==typeof e.components?e.components(s):e.components||s:i(e.components),r.createElement(o.Provider,{value:t},e.children)}}}]);