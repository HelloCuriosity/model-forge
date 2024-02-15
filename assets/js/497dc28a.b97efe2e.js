"use strict";(self.webpackChunkwebsite=self.webpackChunkwebsite||[]).push([[302],{4198:(e,n,t)=>{t.r(n),t.d(n,{assets:()=>a,contentTitle:()=>d,default:()=>p,frontMatter:()=>s,metadata:()=>i,toc:()=>c});var o=t(5893),r=t(1151);const s={sidebar_position:12},d="Long",i={id:"supported-types/long",title:"Long",description:"The long provider generates a random long value between two longs.",source:"@site/docs/supported-types/long.md",sourceDirName:"supported-types",slug:"/supported-types/long",permalink:"/model-forge/docs/supported-types/long",draft:!1,unlisted:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/supported-types/long.md",tags:[],version:"current",sidebarPosition:12,frontMatter:{sidebar_position:12},sidebar:"tutorialSidebar",previous:{title:"Instant",permalink:"/model-forge/docs/supported-types/instant"},next:{title:"Short",permalink:"/model-forge/docs/supported-types/short"}},a={},c=[{value:"Default Behavoir",id:"default-behavoir",level:3},{value:"Extending the Provider",id:"extending-the-provider",level:3}];function l(e){const n={code:"code",h1:"h1",h3:"h3",p:"p",pre:"pre",...(0,r.a)(),...e.components};return(0,o.jsxs)(o.Fragment,{children:[(0,o.jsx)(n.h1,{id:"long",children:"Long"}),"\n",(0,o.jsxs)(n.p,{children:["The ",(0,o.jsx)(n.code,{children:"long"})," provider generates a random long value between two longs."]}),"\n",(0,o.jsx)(n.h3,{id:"default-behavoir",children:"Default Behavoir"}),"\n",(0,o.jsxs)(n.p,{children:["Between ",(0,o.jsx)(n.code,{children:"-9223372036854775807L - 1L"})," and ",(0,o.jsx)(n.code,{children:"9223372036854775807L"})]}),"\n",(0,o.jsx)(n.h3,{id:"extending-the-provider",children:"Extending the Provider"}),"\n",(0,o.jsxs)(n.p,{children:["If you need a specific range you can pass custom ",(0,o.jsx)(n.code,{children:"min"})," and ",(0,o.jsx)(n.code,{children:"max"})," values to the provider:"]}),"\n",(0,o.jsx)(n.pre,{children:(0,o.jsx)(n.code,{className:"language-kotlin",children:"    val long = LongProvider(min = 1L, max = 15L).get()\n"})})]})}function p(e={}){const{wrapper:n}={...(0,r.a)(),...e.components};return n?(0,o.jsx)(n,{...e,children:(0,o.jsx)(l,{...e})}):l(e)}},1151:(e,n,t)=>{t.d(n,{Z:()=>i,a:()=>d});var o=t(7294);const r={},s=o.createContext(r);function d(e){const n=o.useContext(s);return o.useMemo((function(){return"function"==typeof e?e(n):{...n,...e}}),[n,e])}function i(e){let n;return n=e.disableParentContext?"function"==typeof e.components?e.components(r):e.components||r:d(e.components),o.createElement(s.Provider,{value:n},e.children)}}}]);